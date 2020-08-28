package com.simple.mvi.ui.features

import com.simple.mvi.ui.common.ViewAction

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeAction : ViewAction {
    data class SearchCharacters(val name: String) : HomeAction()
    object AllCharacters : HomeAction()
}