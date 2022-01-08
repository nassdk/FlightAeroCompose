package com.nassdk.flights.domain.entity

data class RTFlightsEntity(
    val flights: List<FlightEntity>,
    val pagination: PaginationEntity,
)