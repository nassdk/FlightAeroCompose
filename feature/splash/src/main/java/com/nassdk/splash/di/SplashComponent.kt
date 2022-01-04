package com.nassdk.splash.di

import com.nassdk.di.scopes.FeatureScope
import com.nassdk.splash.SplashApi
import dagger.Component

@FeatureScope
@Component(modules = [SplashModule::class])
internal interface SplashComponent {

    @Component.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun moduleApi(): SplashApi
}