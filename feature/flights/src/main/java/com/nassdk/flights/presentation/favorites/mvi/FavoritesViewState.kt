package com.nassdk.flights.presentation.favorites.mvi

import com.nassdk.common.base.BaseViewState
import com.nassdk.flights.domain.entity.FlightEntity

data class FavoritesViewState(
    val flights: List<FlightEntity>
) : BaseViewState {

    companion object {
        fun provideInitialState(): FavoritesViewState {
            return FavoritesViewState(flights = emptyList())
        }
    }
}