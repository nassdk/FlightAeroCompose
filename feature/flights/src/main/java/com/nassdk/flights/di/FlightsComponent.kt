package com.nassdk.flights.di

import com.nassdk.di.scopes.FeatureScope
import com.nassdk.flights.FlightsApi
import dagger.Component

@Component(modules = [FlightsModule::class])
@FeatureScope
interface FlightsComponent {

    @Component.Factory
    interface Factory {
        fun create(): FlightsComponent
    }

    fun moduleApi(): FlightsApi
}