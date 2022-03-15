package com.nassdk.flights.domain.repo

import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.RTFlightsEntity

interface FlightsRepository {
    suspend fun getFavorites(): List<FlightEntity>
    suspend fun getRealTimeFlights(offset: Int): RTFlightsEntity
    suspend fun addToFavorites(entity: FlightEntity)
    suspend fun removeFromFavorites(entity: FlightEntity)
}