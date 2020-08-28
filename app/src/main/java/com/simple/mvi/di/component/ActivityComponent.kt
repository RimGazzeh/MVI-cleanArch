package com.simple.mvi.di.component

import com.simple.mvi.MVIApplication
import com.simple.mvi.di.annotations.ActivityScope
import com.simple.mvi.di.common.AppRouter
import com.simple.mvi.di.module.ActivityModule
import com.simple.mvi.ui.common.RootBaseActivity
import dagger.Component

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [MVIApplication::class])
interface ActivityComponent {
    fun inject(baseActivity: RootBaseActivity)
    fun appRouter(): AppRouter
}