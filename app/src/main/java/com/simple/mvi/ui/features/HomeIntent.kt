package com.simple.mvi.ui.features

import com.simple.mvi.ui.common.ViewIntent

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeIntent : ViewIntent {
    object LoadAllCharacters : HomeIntent()
    sealed class SearchCharacter(name: String) : HomeIntent()
    object ClearSearch : HomeIntent()
}