package com.simple.data.common

/**
 * Created by Rim Gazzah on 8/28/20.
 **/
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: CallErrors) : Result<Nothing>()
    object Loading : Result<Nothing>()
}