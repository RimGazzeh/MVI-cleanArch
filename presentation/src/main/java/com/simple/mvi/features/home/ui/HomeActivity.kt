package com.simple.mvi.features.home.ui

import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.simple.mvi.common.BaseActivity
import com.simple.mvi.common.getMessage
import com.simple.mvi.common.runIfTrue
import com.simple.mvi.databinding.ActivityMainBinding
import com.simple.mvi.features.home.HomeViewModel
import com.simple.mvi.features.home.HomeAction
import com.simple.mvi.features.home.HomeIntent
import com.simple.mvi.features.home.HomeState

class HomeActivity :
    BaseActivity<HomeIntent, HomeAction, HomeState, HomeViewModel>(HomeViewModel::class.java) {

    private val mAdapter = CharactersAdapter()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun initUI() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.homeListCharacters.adapter = mAdapter
    }

    override fun initDATA() {
        dispatchIntent(HomeIntent.LoadAllCharacters)
    }

    override fun initEVENT() {
        binding.homeSearchImage.setOnClickListener {
            binding.homeSearchText.text.isNullOrBlank().not().runIfTrue {
                dispatchIntent(HomeIntent.SearchCharacter(binding.homeSearchText.text.toString()))
            }
        }
        binding.homeSearchText.doOnTextChanged { text, _, _, _ ->
            text.isNullOrBlank()
                .and(mState is HomeState.ResultSearch)
                .runIfTrue {
                    dispatchIntent(HomeIntent.ClearSearch)
                }
        }
    }

    override fun render(state: HomeState) {
        binding.homeProgress.isVisible = state is HomeState.Loading
        binding.homeMessage.isVisible = state is HomeState.Exception
        binding.homeListCharacters.isVisible =
            state is HomeState.ResultSearch || state is HomeState.ResultAllPersona

        when (state) {
            is HomeState.ResultAllPersona -> {
                mAdapter.updateList(state.data)
            }

            is HomeState.ResultSearch -> {
                mAdapter.updateList(state.data)
                // other logic ...
            }

            is HomeState.Exception -> {
                binding.homeMessage.text = state.callErrors.getMessage(this)
            }

            else -> {}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}