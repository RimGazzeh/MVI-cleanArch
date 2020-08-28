package com.simple.mvi.di.viewmodels


import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Rim Gazzah on 8/27/20.
 **/
@Module
abstract class ViewModelModule {

   /* @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindLoginViewModel(homeViewModel: HomeViewModel): ViewModel*/

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}