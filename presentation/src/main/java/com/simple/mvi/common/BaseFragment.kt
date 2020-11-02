package com.simple.mvi.common

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
abstract class BaseFragment(@LayoutRes val layoutId: Int) : Fragment(layoutId) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initView()
    abstract fun initData()
}