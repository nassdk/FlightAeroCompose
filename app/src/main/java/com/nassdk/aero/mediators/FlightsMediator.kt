package com.nassdk.aero.mediators

import androidx.annotation.MainThread
import com.nassdk.di.ModuleDependencyProvider
import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsDependencies
import com.nassdk.flights.FlightsFeature
import com.nassdk.flights.data.network.api.FlightsRestApi

class FlightsMediator {

    init {
        FlightsFeature.dependencies = ModuleDependencyProvider { createDependencies() }
    }

    @MainThread
    fun getApi(): FlightsApi = FlightsFeature.getApi()

    private fun createDependencies(): FlightsDependencies {
        return object : FlightsDependencies {
            override fun provideRestApi(): FlightsRestApi {
                return MediatorManager.networkMediator
                    .getApi()
                    .provideApiClass(
                        FlightsRestApi::class.java
                    )
            }
        }
    }
}