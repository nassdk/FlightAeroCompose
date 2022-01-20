package com.nassdk.flightdetails.domain.entity

data class FlightEntity(
    val status: FlightStatus,
    val number: String,
    val arrivalTimezone: String,
    val arrivalTime: String,
    val departureTimezone: String,
    val departureTime: String,
    val arrDay: String,
    val depDay: String,
    val arrTime: String,
    val depTime: String,
    val flightTime: String
)