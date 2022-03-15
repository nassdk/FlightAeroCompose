package com.nassdk.flights

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.presentation.details.mvi.FlightDetailsViewEvent
import com.nassdk.flights.presentation.details.mvi.FlightDetailsViewModel
import com.nassdk.flights.presentation.details.mvi.FlightDetailsViewState
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewModel
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewEvent
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewState
import com.nassdk.flights.presentation.list.FlightsViewModel
import com.nassdk.flights.presentation.list.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.list.mvi.FlightsViewState
import javax.inject.Inject
import javax.inject.Provider

class FlightsApiImpl @Inject constructor() : FlightsApi {

    @Inject lateinit var viewModelFactoryFlights: Provider<FlightsViewModel>
    @Inject lateinit var viewModelFactoryFavorites: Provider<FavoritesViewModel>
    @Inject lateinit var flightDetailFactory: FlightDetailsViewModel.Factory

    override fun provideFlightsVM(): BaseViewModel<FlightsViewState, FlightsViewEvent> {
        return viewModelFactoryFlights.get()
    }

    override fun provideFlightDetailsVM(entity: FlightEntity): BaseViewModel<FlightDetailsViewState, FlightDetailsViewEvent> {
        return flightDetailFactory.create(entity = entity)
    }

    override fun provideFavoritesVM(): BaseViewModel<FavoritesViewState, FavoritesViewEvent> {
        return viewModelFactoryFavorites.get()
    }
}