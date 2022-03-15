package com.nassdk.flights.data.mapper

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.db.dto.FlightLocalDto
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.FlightStatus
import javax.inject.Inject

internal class FavoritesMapper @Inject constructor() : BaseMapper<FlightLocalDto, FlightEntity> {

    override fun map(from: FlightLocalDto): FlightEntity {

        return FlightEntity(
            status = FlightStatus.getBy(code = requireNotNull(from.statusCode)),
            number = requireNotNull(from.number),
            arrivalTimezone = requireNotNull(from.arrivalTimezone),
            arrivalTime = requireNotNull(from.arrivalTime),
            departureTimezone = requireNotNull(from.departureTimezone),
            departureTime = requireNotNull(from.departureTime),
            arrDay = requireNotNull(from.arrDay),
            depDay = requireNotNull(from.depDay),
            arrTime = requireNotNull(from.arrTime),
            depTime = requireNotNull(from.depTime),
            flightTime = requireNotNull(from.flightTime),
            isFavorite = true
        )
    }
}