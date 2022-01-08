package com.nassdk.flights.di

import com.nassdk.di.scopes.FeatureScope
import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsDependencies
import dagger.Component

@Component(
    modules = [FlightsModule::class],
    dependencies = [FlightsDependencies::class]
)
@FeatureScope
internal interface FlightsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            flightsDependencies: FlightsDependencies,
        ): FlightsComponent
    }

    fun moduleApi(): FlightsApi
}