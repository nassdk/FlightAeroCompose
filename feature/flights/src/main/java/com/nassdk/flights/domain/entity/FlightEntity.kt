package com.nassdk.flights.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
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
    val flightTime: String,
    val isFavorite: Boolean
) : Parcelable
