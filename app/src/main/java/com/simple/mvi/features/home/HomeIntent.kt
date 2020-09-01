package com.simple.mvi.features.home

import com.simple.mvi.common.ViewIntent

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeIntent : ViewIntent {
    object LoadAllCharacters : HomeIntent()
    data class SearchCharacter(val name: String) : HomeIntent()
    object ClearSearch : HomeIntent()
}