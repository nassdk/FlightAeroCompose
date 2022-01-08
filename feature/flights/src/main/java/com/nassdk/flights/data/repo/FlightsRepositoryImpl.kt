package com.nassdk.flights.data.repo

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.network.api.FlightsRestApi
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.FlightStatus
import com.nassdk.flights.domain.entity.PaginationEntity
import com.nassdk.flights.domain.entity.RTFlightsEntity
import com.nassdk.flights.domain.repo.FlightsRepository
import javax.inject.Inject

internal class FlightsRepositoryImpl @Inject constructor(
    private val api: FlightsRestApi,
    private val mapper: BaseMapper<RTFlightsResponseDto, RTFlightsEntity>,
) : FlightsRepository {

    override suspend fun getRealTimeFlights(offset: Int): RTFlightsEntity {
        val newOffset = if (offset == 30) offset + 9 else offset + 10
        val entities = RTFlightsEntity(

            pagination = PaginationEntity(
                limit = 40,
                offset = newOffset,
                total = 999
            ),
            flights = listOf(
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P"
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "21321321312",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscowwwwwww",
                    departureTime = "21.12.21",
                    departureTimezone = "S-Pppppp"
                )
            )
        )
        return entities
    }
}