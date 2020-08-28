package com.simple.mvi.di.common

import com.simple.mvi.di.annotations.ActivityScope
import com.simple.mvi.ui.common.RootBaseActivity
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 8/27/20.
 **/
@ActivityScope
class AppRouter @Inject constructor(private val activity : RootBaseActivity){


}