package com.simple.mvi.features.home.ui

import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.simple.mvi.R
import com.simple.mvi.common.BaseActivity
import com.simple.mvi.common.runIfTrue
import com.simple.mvi.features.home.HomeViewModel
import com.simple.mvi.features.home.HomeAction
import com.simple.mvi.features.home.HomeIntent
import com.simple.mvi.features.home.HomeState
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity :
    BaseActivity<HomeIntent, HomeAction, HomeState, HomeViewModel>(HomeViewModel::class.java) {

    private val mAdapter = CharactersAdapter()
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        homeListCharacters.adapter = mAdapter
    }

    override fun initDATA() {
        dispatchIntent(HomeIntent.LoadAllCharacters)
    }

    override fun initEVENT() {
        homeSearchImage.setOnClickListener {
            homeSearchText.text.isNullOrBlank().not().runIfTrue {
                dispatchIntent(HomeIntent.SearchCharacter(homeSearchText.text.toString()))
            }
        }
        homeSearchText.doOnTextChanged { text, _, _, _ ->
            text.isNullOrBlank()
                .and(mState is HomeState.ResultSearch)
                .runIfTrue {
                    dispatchIntent(HomeIntent.ClearSearch)
                }
        }
    }

    override fun render(state: HomeState) {
        homeProgress.isVisible = state is HomeState.Loading
        homeMessage.isVisible = state is HomeState.Exception
        homeListCharacters.isVisible =
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
                homeMessage.text = state.callErrors.getMessage()
            }
        }
    }
}