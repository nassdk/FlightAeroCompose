package com.nassdk.splash

import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.presentation.mvi.SplashViewEvent
import com.nassdk.splash.presentation.mvi.SplashViewState
import com.nassdk.splash.presentation.SplashViewModel
import javax.inject.Inject
import javax.inject.Provider

class SplashApiImpl @Inject constructor() : SplashApi {

    @Inject lateinit var viewModelFactory: Provider<SplashViewModel>

    override fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent> {
        return viewModelFactory.get()
    }
}