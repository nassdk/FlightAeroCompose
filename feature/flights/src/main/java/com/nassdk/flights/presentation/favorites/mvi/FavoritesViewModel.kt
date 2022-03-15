package com.nassdk.flights.presentation.favorites.mvi

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.domain.repo.FlightsRepository
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val repository: FlightsRepository
) : BaseViewModel<FavoritesViewState, FavoritesViewEvent>(
    initialState = FavoritesViewState.provideInitialState()
) {
    override fun observe(event: FavoritesViewEvent) = Unit

    init {
        retrieveFlights()
    }

    private fun retrieveFlights() {

        launchIOCoroutine(
            function = {
                val flights = repository.getFavorites()

                updateStateFromIo {
                    copy(flights = flights)
                }
            }
        )
    }
}