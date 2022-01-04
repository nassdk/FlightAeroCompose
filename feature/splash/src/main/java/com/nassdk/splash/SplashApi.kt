package com.nassdk.splash

import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.presentation.model.SplashViewEvent
import com.nassdk.splash.presentation.model.SplashViewState

interface SplashApi {

    fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent>
}