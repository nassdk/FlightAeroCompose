package com.nassdk.splash.di

import com.nassdk.di.scopes.FeatureScope
import com.nassdk.splash.SplashApi
import com.nassdk.splash.SplashApiImpl
import dagger.Binds
import dagger.Module

@Module
internal interface SplashModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: SplashApiImpl): SplashApi
}