/*
 * *
 *  * Created by Ahlem Jarrar on 1/29/20 4:29 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/29/20 4:28 PM
 *
 *
 */

package com.simple.mvi.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
