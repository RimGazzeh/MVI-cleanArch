package com.simple.mvi.features.home

import com.simple.data.managers.CharactersManager
import com.simple.mvi.common.BaseViewModel
import com.simple.mvi.features.home.HomeAction
import com.simple.mvi.features.home.HomeIntent
import com.simple.mvi.features.home.HomeState
import com.simple.mvi.features.home.reduce
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
class HomeViewModel @Inject constructor(private val dataManager: CharactersManager) :
    BaseViewModel<HomeIntent, HomeAction, HomeState>() {
    override fun intentToAction(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.LoadAllCharacters -> HomeAction.AllCharacters
            is HomeIntent.ClearSearch -> HomeAction.AllCharacters
            is HomeIntent.SearchCharacter -> HomeAction.SearchCharacters(intent.name)
        }
    }


    override fun handleAction(action: HomeAction) {
        launchOnUI {
            when (action) {
                is HomeAction.AllCharacters -> {
                    dataManager.getAllCharacters().collect {
                        mState.postValue(it.reduce())
                    }
                }
                is HomeAction.SearchCharacters -> {
                    dataManager.searchCharacters(action.name).collect {
                        mState.postValue(it.reduce(true))
                    }
                }
            }
        }
    }
}