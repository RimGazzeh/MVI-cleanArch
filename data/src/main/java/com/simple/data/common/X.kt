package com.simple.data.common

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

fun <T : Any> Flow<Result<T>>.applyCommonSideEffects() =
    retryWhen { cause, attempt ->
        when {
            (cause is IOException && attempt < Utils.MAX_RETRIES) -> {
                delay(Utils.getBackoffDelay(attempt))
                true
            }
            else -> {
                false
            }
        }
    }
        .onStart {
            emit(Result.Loading)
        }
