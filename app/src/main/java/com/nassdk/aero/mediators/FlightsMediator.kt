package com.nassdk.aero.mediators

import com.nassdk.flights.FlightsApi
import com.nassdk.flights.FlightsFeature

class FlightsMediator {

    fun getApi(): FlightsApi = FlightsFeature.getApi()
}