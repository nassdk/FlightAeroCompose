package com.nassdk.aero.mediators

import androidx.annotation.MainThread
import com.nassdk.splash.SplashApi
import com.nassdk.splash.SplashFeature

class SplashMediator {

    @MainThread
    fun getApi(): SplashApi = SplashFeature.getApi()
}