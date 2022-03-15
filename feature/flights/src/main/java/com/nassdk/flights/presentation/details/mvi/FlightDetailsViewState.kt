package com.nassdk.flights.presentation.details.mvi

import com.nassdk.common.base.BaseViewState
import com.nassdk.flights.domain.entity.FlightEntity

data class FlightDetailsViewState(
    val entity: FlightEntity?
) : BaseViewState {
    companion object {
        fun provideInitialState(entity: FlightEntity): FlightDetailsViewState {
            return FlightDetailsViewState(
                entity = entity
            )
        }
    }
}