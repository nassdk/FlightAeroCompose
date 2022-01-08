package com.nassdk.flights

import androidx.annotation.MainThread
import com.nassdk.di.ModuleDependencyProvider
import com.nassdk.flights.data.network.api.FlightsRestApi
import com.nassdk.flights.di.DaggerFlightsComponent
import com.nassdk.flights.di.FlightsComponent

object FlightsFeature {

    private var component: FlightsComponent? = null

    var dependencies: ModuleDependencyProvider<FlightsDependencies>? = null

    @MainThread
    fun getApi(): FlightsApi = getComponent().moduleApi()

    internal fun getComponent(): FlightsComponent =
        component ?: run {

            component = DaggerFlightsComponent.factory().create(
                flightsDependencies = requireNotNull(
                    dependencies?.getDependencies()
                )
            )

            requireNotNull(component)
        }

    internal fun destroyModuleGraph() {
        component = null
    }
}


interface FlightsDependencies {
    fun provideRestApi(): FlightsRestApi
}
