package com.simple.mvi.ui.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
abstract class BaseActivity<STATE : ViewState ,  VM : ViewModel> : AppCompatActivity(), IViewRenderer<STATE> {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutResId())
        initView()
        initData()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun initView()
    abstract fun initData()
}