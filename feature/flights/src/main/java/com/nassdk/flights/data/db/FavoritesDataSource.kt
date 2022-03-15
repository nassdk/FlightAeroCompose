package com.nassdk.flights.data.db

import com.nassdk.flights.data.db.dto.FlightLocalDto

interface FavoritesDataSource {
    suspend fun getFavorites(): List<FlightLocalDto>
    suspend fun addToFavorites(dto: FlightLocalDto)
    suspend fun removeFromFavorites(dto: FlightLocalDto)
    fun isFlightFavorite(number: String): Boolean
}