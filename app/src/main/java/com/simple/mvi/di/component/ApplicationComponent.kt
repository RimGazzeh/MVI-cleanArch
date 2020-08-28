package com.simple.mvi.di.component

import com.simple.data.ApiService
import com.simple.data.managers.CharactersManager
import com.simple.mvi.MVIApplication
import com.simple.mvi.di.module.ApplicationModule
import com.simple.mvi.di.module.NetworkModule
import com.simple.mvi.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: MVIApplication): Builder
    }

 //  fun provideDaggerViewModelFactory(): DaggerViewModelFactory
}