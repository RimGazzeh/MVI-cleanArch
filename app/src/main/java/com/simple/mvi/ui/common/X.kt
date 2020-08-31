package com.simple.mvi.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

/**
 * Created by Rim Gazzah on 8/31/20.
 **/
fun < T : ViewModel> RootBaseActivity.viewModelProvider(factory: ViewModelProvider.Factory, model: KClass<T>):T{
    return ViewModelProvider(this, factory).get(model.java)
}