package com.simple.mvi.ui.features

import com.simple.domain.entities.Persona
import com.simple.mvi.ui.common.ViewState

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeState : ViewState{
    object Loading : HomeState()
    data class Result(val data : List<Persona>, val isSearchMode :Boolean): HomeState()
    data class Exception(val message: String) : HomeState()
}