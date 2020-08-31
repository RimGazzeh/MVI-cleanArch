package com.simple.mvi.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simple.mvi.MVIApplication
import com.simple.mvi.di.common.AppRouter
import com.simple.mvi.di.component.ActivityComponent
import com.simple.mvi.di.component.DaggerActivityComponent
import com.simple.mvi.di.module.ActivityModule
import com.simple.mvi.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 8/27/20.
 **/
open class RootBaseActivity : AppCompatActivity() {

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent(MVIApplication.appComponents).build()
    }

    @Inject
    lateinit var appRouter: AppRouter

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
    }


}