package com.nassdk.flights.presentation.ui

import com.nassdk.common.helpers.ItemUi
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.FlightStatus

sealed class FlightsListModel : ItemUi {

    object Loading : FlightsListModel()

    data class Flight(
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
    ) : FlightsListModel() {

        companion object {

            fun FlightEntity.map2AdapterItem(): Flight {
                return Flight(
                    status = status,
                    number = number,
                    arrivalTimezone = arrivalTimezone,
                    arrivalTime = arrivalTime,
                    departureTimezone = departureTimezone,
                    departureTime = departureTime,
                    arrDay = arrDay,
                    arrTime = arrTime,
                    depDay = depDay,
                    depTime = depTime,
                    flightTime = flightTime
                )
            }

            fun Flight.map2Entity(): FlightEntity {
                return FlightEntity(
                    status = status,
                    number = number,
                    arrivalTimezone = arrivalTimezone,
                    arrivalTime = arrivalTime,
                    departureTimezone = departureTimezone,
                    departureTime = departureTime,
                    arrDay = arrDay,
                    arrTime = arrTime,
                    depDay = depDay,
                    depTime = depTime,
                    flightTime = flightTime
                )
            }
        }
    }
}
