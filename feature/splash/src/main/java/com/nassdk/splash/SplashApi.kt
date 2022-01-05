package com.nassdk.splash

import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.presentation.mvi.SplashViewEvent
import com.nassdk.splash.presentation.mvi.SplashViewState

interface SplashApi {

    fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent>
}