package com.simple.mvi

import android.app.Application
import com.simple.mvi.di.component.ApplicationComponent
import com.simple.mvi.di.component.DaggerApplicationComponent

/**
 * Created by Rim Gazzah on 8/27/20.
 **/
class MVIApplication: Application() {

    companion object {
        lateinit var appComponents: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDI()
    }

    private fun initDI(): ApplicationComponent =
        DaggerApplicationComponent.builder().application(this).build()
}