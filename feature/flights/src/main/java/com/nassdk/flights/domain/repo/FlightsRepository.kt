package com.nassdk.flights.domain.repo

import com.nassdk.flights.domain.entity.RTFlightsEntity

interface FlightsRepository {
    suspend fun getRealTimeFlights(offset: Int): RTFlightsEntity
}