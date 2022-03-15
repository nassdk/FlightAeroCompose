package com.nassdk.flights.data.mapper

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.db.dto.FlightLocalDto
import com.nassdk.flights.domain.entity.FlightEntity
import javax.inject.Inject

internal class FavoritesToDtoMapper @Inject constructor() : BaseMapper<FlightEntity, FlightLocalDto> {

    override fun map(from: FlightEntity): FlightLocalDto {

        return FlightLocalDto(
            number = from.number,
            statusCode = from.status.code,
            arrivalTime = from.arrivalTime,
            arrivalTimezone = from.arrivalTimezone,
            depDay = from.depDay,
            depTime = from.depTime,
            departureTime = from.departureTime,
            departureTimezone = from.departureTimezone,
            arrTime = from.arrTime,
            arrDay = from.arrDay,
            flightTime = from.flightTime
        )
    }
}