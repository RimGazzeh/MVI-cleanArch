package com.simple.mvi.ui.features

import com.simple.mvi.ui.common.ViewAction

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeAction : ViewAction {
    sealed class SearchCharacters(name: String) : HomeAction()
    object AllCharacters : HomeAction()
}