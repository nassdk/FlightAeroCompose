package com.nassdk.flights.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArrivalDto(
    val timezone: String?,
    val estimated: String
)
