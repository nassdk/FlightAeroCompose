package com.nassdk.flights

import androidx.annotation.MainThread
import com.nassdk.flights.di.DaggerFlightsComponent
import com.nassdk.flights.di.FlightsComponent

object FlightsFeature {

    private var component: FlightsComponent? = null

    @MainThread
    fun getApi(): FlightsApi = getComponent().moduleApi()

    internal fun getComponent(): FlightsComponent =
        component ?: run {

            component = DaggerFlightsComponent.factory().create()

            requireNotNull(component)
        }

    internal fun destroyModuleGraph() {
        component = null
    }
}