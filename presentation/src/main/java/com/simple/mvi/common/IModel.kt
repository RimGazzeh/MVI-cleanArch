package com.simple.mvi.common

import androidx.lifecycle.LiveData

/**
 * Created by Rim Gazzah on 8/20/20.
 **/

interface IModel<STATE, INTENT> {

    val state: LiveData<STATE>

    fun dispatchIntent(intent: INTENT)
}