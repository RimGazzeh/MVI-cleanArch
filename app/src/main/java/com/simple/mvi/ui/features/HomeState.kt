package com.simple.mvi.ui.features

import com.simple.domain.entities.Persona
import com.simple.mvi.ui.common.ViewState

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
data class HomeState(
    val isProcessing: Boolean = true,
    val listCharacter: List<Persona> = emptyList(),
    val searchMode: String,
    val error: String
) : ViewState