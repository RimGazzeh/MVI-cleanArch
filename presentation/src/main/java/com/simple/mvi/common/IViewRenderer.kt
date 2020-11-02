package com.simple.mvi.common

/**
 * Created by Rim Gazzah on 8/20/20.
 **/
interface IViewRenderer<STATE> {
    fun render(state: STATE)
}