package com.simple.mvi.features.home

import com.simple.data.common.Result
import com.simple.domain.entities.Persona

/**
 * Created by Rim Gazzah on 8/31/20.
 **/

fun Result<List<Persona>>.reduce(isSearchMode :Boolean = false): HomeState {
    return when (this) {
        is Result.Success -> HomeState.Result(data, isSearchMode)
        is Result.Error -> HomeState.Exception(exception)
        is Result.Loading -> HomeState.Loading
    }
}