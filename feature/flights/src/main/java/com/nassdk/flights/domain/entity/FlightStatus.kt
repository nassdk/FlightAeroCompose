package com.nassdk.flights.domain.entity

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.nassdk.flights.R

enum class FlightStatus(
    @StringRes val value: Int,
    @ColorRes val tint: Color,
    val code: String,
) {
    InFlight(
        value = R.string.flights_status_name_in_flight,
        tint = Color(0xFF0057FF),
        code = "active"
    ),

    Canceled(
        value = R.string.flights_status_name_canceled,
        tint = Color(0xFFC7BF00),
        code = "cancelled"
    ),

    Scheduled(
        value = R.string.flights_status_name_scheduled,
        tint = Color(0xFFFF7A00),
        code = "scheduled"
    ),

    Landed(
        value = R.string.flights_status_name_landed,
        tint = Color(0xFFFF7A00),
        code = "landed"
    );

    companion object {
        fun getBy(code: String): FlightStatus {
            values().forEach {
                if (it.code == code) {
                    return it
                }
            }
            throw IllegalArgumentException("flight status with code $code not found")
        }
    }
}
