package com.nassdk.aero.mediators

import com.nassdk.splash.SplashApi
import com.nassdk.splash.SplashFeature

class SplashMediator {

    fun getApi(): SplashApi = SplashFeature.getApi()
}