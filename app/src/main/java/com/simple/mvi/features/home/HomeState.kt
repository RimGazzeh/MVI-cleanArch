package com.simple.mvi.features.home

import com.simple.data.CallErrors
import com.simple.domain.entities.Persona
import com.simple.mvi.common.ViewState

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
sealed class HomeState : ViewState{
    object Loading : HomeState()
    data class ResultAllPersona(val data : List<Persona>): HomeState()
    data class ResultSearch(val data : List<Persona>): HomeState()
    data class Exception(val callErrors: CallErrors) : HomeState()
}