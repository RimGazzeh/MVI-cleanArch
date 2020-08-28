package com.simple.mvi.ui.features

import com.simple.data.managers.CharactersManager
import com.simple.mvi.ui.common.BaseViewModel
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
        when (action) {
            is HomeAction.AllCharacters -> {
                dataManager.getAllCharacters()
            }
            is HomeAction.SearchCharacters -> {
                dataManager.searchCharacters(action.name)
            }
        }
    }
}