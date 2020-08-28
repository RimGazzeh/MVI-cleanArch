package com.simple.mvi.di.module

import android.content.Context
import com.simple.data.ApiService
import com.simple.data.DataManager
import com.simple.mvi.MVIApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
@Module
class ApplicationModule {

    @Provides
    fun provideApplication(application : MVIApplication) : Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDataManagerAccessor(): DataManager {
        return DataManager()
    }
}