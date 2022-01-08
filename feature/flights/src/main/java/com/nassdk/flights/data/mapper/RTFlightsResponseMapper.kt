package com.nassdk.flights.data.mapper

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.network.dto.FlightDto
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.FlightStatus
import com.nassdk.flights.domain.entity.PaginationEntity
import com.nassdk.flights.domain.entity.RTFlightsEntity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

internal class RTFlightsResponseMapper @Inject constructor() :
    BaseMapper<RTFlightsResponseDto, RTFlightsEntity> {

    override fun map(from: RTFlightsResponseDto): RTFlightsEntity {

        return RTFlightsEntity(
            pagination = PaginationEntity(
                limit = from.pagination.limit,
                offset = from.pagination.limit,
                total = from.pagination.total
            ),
            flights = mapFlights(flights = from.data)
        )
    }

    private fun mapFlights(flights: List<FlightDto>) = flights.map { flight ->
        flight.run {
            FlightEntity(
                status = FlightStatus.getBy(code = status),
                number = flight.flightInfo.number,
                arrivalTime = arrival.estimated.convert2ProperPattern().orEmpty(),
                arrivalTimezone = arrival.timezone ?: DEFAULT_TIME_ZONE_VALUE,
                departureTime = departure.estimated.convert2ProperPattern().orEmpty(),
                departureTimezone = departure.timezone ?: DEFAULT_TIME_ZONE_VALUE
            )
        }
    }

    private fun String.convert2ProperPattern(pattern: String = "dd MMMM HH:mm"): String? {

        val decodeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

        val date = try {
            decodeFormat.parse(this)
        } catch (e: ParseException) {
            return null
        }

        return SimpleDateFormat(pattern, Locale.getDefault()).format(date)
    }

    private companion object {
        private const val DEFAULT_TIME_ZONE_VALUE = "Unknown"
    }
}