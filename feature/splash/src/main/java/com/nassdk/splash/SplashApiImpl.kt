package com.nassdk.splash

import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.presentation.model.SplashViewEvent
import com.nassdk.splash.presentation.model.SplashViewState
import com.nassdk.splash.presentation.mvi.SplashViewModel
import javax.inject.Inject
import javax.inject.Provider

class SplashApiImpl @Inject constructor() : SplashApi {

    @Inject lateinit var viewModelFactory: Provider<SplashViewModel>

    override fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent> {
        return viewModelFactory.get()
    }
}