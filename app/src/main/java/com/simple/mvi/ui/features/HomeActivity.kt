package com.simple.mvi.ui.features

import androidx.core.view.isVisible
import com.simple.mvi.R
import com.simple.mvi.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity<HomeState, HomeViewModel>() {


    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun render(state: HomeState) {
        home_progress.isVisible = state is HomeState.Loading
        home_message.isVisible = state is HomeState.Exception
        home_list.isVisible = state is HomeState.Result

        when (state){
            is HomeState.Result -> {
            }
            is HomeState.Exception -> {
                home_message.text = state.message
            }
        }
    }
}