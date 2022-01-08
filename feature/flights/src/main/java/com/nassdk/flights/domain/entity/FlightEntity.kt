package com.nassdk.flights.domain.entity

data class FlightEntity(
    val status: FlightStatus,
    val number: String,
    val arrivalTimezone: String,
    val arrivalTime: String,
    val departureTimezone: String,
    val departureTime: String,
)
