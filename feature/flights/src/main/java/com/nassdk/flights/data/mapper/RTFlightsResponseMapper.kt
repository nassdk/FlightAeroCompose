package com.nassdk.flights.data.mapper

import com.nassdk.common.base.BaseMapper
import com.nassdk.common.extensions.orZero
import com.nassdk.flights.data.db.FavoritesDataSource
import com.nassdk.flights.data.network.dto.FlightDto
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.FlightStatus
import com.nassdk.flights.domain.entity.PaginationEntity
import com.nassdk.flights.domain.entity.RTFlightsEntity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

internal class RTFlightsResponseMapper @Inject constructor(
    private val favoritesDataSource: FavoritesDataSource
) : BaseMapper<RTFlightsResponseDto, RTFlightsEntity> {

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
                departureTimezone = departure.timezone ?: DEFAULT_TIME_ZONE_VALUE,
                arrDay = arrival.estimated.convert2ProperPattern(pattern = DAY_PATTERN).orEmpty(),
                arrTime = arrival.estimated.convert2ProperPattern(pattern = TIME_PATTERN).orEmpty(),
                depDay = departure.estimated.convert2ProperPattern(pattern = DAY_PATTERN).orEmpty(),
                depTime = departure.estimated.convert2ProperPattern(pattern = TIME_PATTERN).orEmpty(),
                isFavorite = favoritesDataSource.isFlightFavorite(flight.flightInfo.number),
                flightTime = calculateFlightTime(
                    arrivalTime = arrival.estimated,
                    departureTime = departure.estimated
                )
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

    private fun calculateFlightTime(arrivalTime: String?, departureTime: String?): String {
        val arr = arrivalTime?.toLongOrNull().orZero()
        val dep = departureTime?.toLongOrNull().orZero()
        val diff = arr - dep

        val hours = diff / HOURS_MILLIS
        val mins = diff - hours

        return when {
            hours == 0L && mins == 0L -> ""
            hours == 0L -> "${mins}мин"
            mins == 0L -> "${hours}ч."
            else -> "${hours}ч.${mins}мин"
        }
    }

    private companion object {
        private const val DEFAULT_TIME_ZONE_VALUE = "Unknown"
        private const val DAY_PATTERN = "dd MMMM"
        private const val TIME_PATTERN = "HH:MM"

        private const val HOURS_MILLIS = 60000
    }
}