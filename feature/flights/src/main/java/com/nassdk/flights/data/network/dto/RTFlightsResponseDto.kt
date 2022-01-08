package com.nassdk.flights.data.network.dto

import com.nassdk.flights.data.network.dto.FlightDto
import com.nassdk.flights.data.network.dto.PaginationDto
import kotlinx.serialization.Serializable

@Serializable
data class RTFlightsResponseDto(
    val pagination: PaginationDto,
    val data: List<FlightDto>,
)