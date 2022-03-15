package com.nassdk.flights.presentation.list.ui

import com.nassdk.common.helpers.ItemUi
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.entity.PaginationEntity

interface FlightsUiBuilder {

    val items: List<ItemUi>
    val paginationState: PaginationEntity?
    val shouldPaginate: Boolean

    fun addFlights(flights: List<FlightEntity>)
    fun setPaginationData(entity: PaginationEntity)
}