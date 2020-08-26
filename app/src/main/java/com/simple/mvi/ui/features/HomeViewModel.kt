package com.simple.mvi.ui.features

import androidx.lifecycle.LiveData
import com.simple.mvi.ui.common.BaseViewModel

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
class HomeViewModel(override val state: LiveData<HomeState>) : BaseViewModel<HomeIntent, HomeAction, HomeState>(){
    override fun intentToAction(intent: HomeIntent): HomeAction {
        TODO("Not yet implemented")
    }

    override fun handleAction(action: HomeAction) {
        TODO("Not yet implemented")
    }
}