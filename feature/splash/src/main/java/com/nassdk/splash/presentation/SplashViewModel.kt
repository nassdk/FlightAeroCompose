package com.nassdk.splash.presentation

import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.SplashFeature
import com.nassdk.splash.presentation.mvi.SplashViewEvent
import com.nassdk.splash.presentation.mvi.SplashViewState
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel<SplashViewState, SplashViewEvent>(
    initialState = SplashViewState()
) {

    override fun observe(event: SplashViewEvent) = Unit

    override fun onCleared() {
        SplashFeature.destroyModuleGraph()
        super.onCleared()
    }
}