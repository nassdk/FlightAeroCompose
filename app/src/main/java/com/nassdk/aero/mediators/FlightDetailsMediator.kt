package com.nassdk.aero.mediators

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.domain.entity.FlightEntity

class FlightDetailsMediator {

    fun mapFlightEntity(entity: FlightEntity): com.nassdk.flightdetails.domain.entity.FlightEntity {
        return FlightEntityMapper().map(from = entity)
    }

    class FlightEntityMapper : BaseMapper<FlightEntity,
            com.nassdk.flightdetails.domain.entity.FlightEntity> {

        override fun map(from: FlightEntity): com.nassdk.flightdetails.domain.entity.FlightEntity {
            return com.nassdk.flightdetails.domain.entity.FlightEntity(
                status = com.nassdk.flightdetails.domain.entity.FlightStatus.getBy(code = from.status.code),
                number = from.number,
                arrivalTimezone = from.arrivalTimezone,
                arrivalTime = from.arrivalTime,
                departureTimezone = from.departureTimezone,
                departureTime = from.departureTime,
                arrDay = from.arrDay,
                depDay = from.depDay,
                arrTime = from.arrTime,
                depTime = from.depTime,
                flightTime = from.flightTime
            )
        }
    }
}