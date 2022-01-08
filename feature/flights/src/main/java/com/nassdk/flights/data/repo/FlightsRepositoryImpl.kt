package com.nassdk.flights.data.repo

import com.nassdk.common.base.BaseMapper
import com.nassdk.flights.data.network.api.FlightsRestApi
import com.nassdk.flights.data.network.dto.RTFlightsResponseDto
import com.nassdk.flights.domain.entity.RTFlightsEntity
import com.nassdk.flights.domain.repo.FlightsRepository
import javax.inject.Inject

internal class FlightsRepositoryImpl @Inject constructor(
    private val api: FlightsRestApi,
    private val mapper: BaseMapper<RTFlightsResponseDto, RTFlightsEntity>,
) : FlightsRepository {

    override suspend fun getRealTimeFlights(offset: Int): RTFlightsEntity {
        return mapper.map(
            from = api.getRealTimeFlights(offset = offset)
        )
    }
}