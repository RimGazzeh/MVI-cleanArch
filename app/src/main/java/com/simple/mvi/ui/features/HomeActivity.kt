package com.simple.mvi.ui.features

import android.os.Bundle
import com.simple.mvi.R
import com.simple.mvi.ui.common.BaseActivity

class HomeActivity : BaseActivity<HomeState, HomeViewModel>() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun render(state: HomeState) {
    }
}