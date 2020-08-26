package com.simple.mvi.ui.common

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
interface IReducer<STATE, PARTIAL_STATE> {
    fun reduce(state: STATE, partialState: PARTIAL_STATE): STATE
}