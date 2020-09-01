package com.simple.mvi.common

import com.simple.data.common.Result

/**
 * Created by Rim Gazzah on 8/26/20.
 **/
interface IReducer<STATE, T :Any> {
    fun reduce(result: Result<T>, state: STATE,): STATE
}