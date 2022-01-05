package com.nassdk.flights.di

import com.nassdk.di.scopes.FeatureScope
import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsApiImpl
import dagger.Binds
import dagger.Module

@Module
interface FlightsModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: FlightsApiImpl): FlightsApi
}