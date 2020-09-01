package com.simple.mvi.features.home.ui

import androidx.core.view.isVisible
import com.simple.mvi.R
import com.simple.mvi.common.BaseActivity
import com.simple.mvi.features.home.HomeViewModel
import com.simple.mvi.features.home.HomeAction
import com.simple.mvi.features.home.HomeIntent
import com.simple.mvi.features.home.HomeState
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity<HomeIntent, HomeAction, HomeState, HomeViewModel>(HomeViewModel::class.java) {

    private val mAdapter  = CharactersAdapter()
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        home_list.adapter = mAdapter
    }

    override fun initDATA() {
        dispatchIntent(HomeIntent.LoadAllCharacters)
    }

    override fun render(state: HomeState) {
        home_progress.isVisible = state is HomeState.Loading
        home_message.isVisible = state is HomeState.Exception
        home_list.isVisible = state is HomeState.Result

        when (state){
            is HomeState.Result -> {
                mAdapter.updateList(state.data)
            }
            is HomeState.Exception -> {
                home_message.text = state.callErrors.getMessage()
            }
        }
    }
}