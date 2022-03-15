package com.nassdk.flights.data.repo

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.db.FavoritesDataSource
import com.nassdk.flights.data.db.dto.FlightLocalDto
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
    private val localDataSource: FavoritesDataSource,
    private val flightsMapper: BaseMapper<RTFlightsResponseDto, RTFlightsEntity>,
    private val favoritesMapper: BaseMapper<FlightLocalDto, FlightEntity>,
    private val dtoMapper: BaseMapper<FlightEntity, FlightLocalDto>
) : FlightsRepository {

    override suspend fun getFavorites(): List<FlightEntity> {
        return localDataSource.getFavorites().map { dto ->
            favoritesMapper.map(from = dto)
        }
    }

    override suspend fun addToFavorites(entity: FlightEntity) {
        localDataSource.addToFavorites(dto = dtoMapper.map(from = entity))
    }

    override suspend fun removeFromFavorites(entity: FlightEntity) {
        localDataSource.removeFromFavorites(dto = dtoMapper.map(from = entity))
    }

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
                    number = "11231",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("11231")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "2324",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("2324")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "33211",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("33211")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "4431",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("4431")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "5321",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("5321")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "63213",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("63213")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "73211",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("8231")
                ),
                FlightEntity(
                    status = FlightStatus.Canceled,
                    number = "8231",
                    arrivalTime = "21.12.21",
                    arrivalTimezone = "Moscow",
                    departureTime = "21.12.21",
                    departureTimezone = "S-P",
                    arrDay = "12 сентрября",
                    arrTime = "12:15",
                    depTime = "15:15",
                    depDay = "13 сентрября",
                    flightTime = "1ч.30мин",
                    isFavorite = localDataSource.isFlightFavorite("8231")
                )
            )
        )
        return entities
    }
}