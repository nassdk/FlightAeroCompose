package com.nassdk.flights

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.presentation.details.mvi.FlightDetailsViewEvent
import com.nassdk.flights.presentation.details.mvi.FlightDetailsViewState
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewEvent
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewState
import com.nassdk.flights.presentation.list.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.list.mvi.FlightsViewState

interface FlightsApi {

    fun provideFlightsVM(): BaseViewModel<FlightsViewState, FlightsViewEvent>
    fun provideFlightDetailsVM(entity: FlightEntity): BaseViewModel<FlightDetailsViewState, FlightDetailsViewEvent>
    fun provideFavoritesVM(): BaseViewModel<FavoritesViewState, FavoritesViewEvent>
}