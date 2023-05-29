package com.simple.mvi.common

import android.os.Bundle

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>>(private val modelClass: Class<VM>) :
    RootBaseActivity(), IViewRenderer<STATE> {
    private lateinit var viewState: STATE
    val mState get() = viewState

    private val viewModel: VM by lazy {
        viewModelProvider(
            this.viewModelFactory,
            modelClass.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        viewModel.state.observe(this) {
            viewState = it
            render(it)
        }
        initDATA()
        initEVENT()
    }

    abstract fun initUI()
    abstract fun initDATA()
    abstract fun initEVENT()
    fun dispatchIntent(intent: INTENT) {
        viewModel.dispatchIntent(intent)
    }
}