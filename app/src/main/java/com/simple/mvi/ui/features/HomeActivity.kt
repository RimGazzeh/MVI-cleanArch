package com.simple.mvi.ui.features

import android.util.Log
import androidx.core.view.isVisible
import com.simple.mvi.R
import com.simple.mvi.ui.common.BaseActivity
import com.simple.mvi.ui.features.machine.HomeAction
import com.simple.mvi.ui.features.machine.HomeIntent
import com.simple.mvi.ui.features.machine.HomeState
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