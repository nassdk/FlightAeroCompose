package com.nassdk.flights.presentation.details.mvi

import com.nassdk.common.base.BaseViewModel
import com.nassdk.common.extensions.orFalse
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.domain.repo.FlightsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class FlightDetailsViewModel @AssistedInject constructor(
    @Assisted private val entity: FlightEntity,
    private val repository: FlightsRepository
) : BaseViewModel<FlightDetailsViewState, FlightDetailsViewEvent>(
    initialState = FlightDetailsViewState.provideInitialState(entity = entity)
) {
    override fun observe(event: FlightDetailsViewEvent) {
        when (event) {
            FlightDetailsViewEvent.UpdateFavoritesState -> updateFavorites()
        }
    }

    private fun updateFavorites() {

        val isFavorite = viewState.value.entity?.isFavorite.orFalse()

        launchIOCoroutine(
            function = {
                if (isFavorite) {
                    repository.removeFromFavorites(entity = entity)
                } else {
                    repository.addToFavorites(entity = entity)
                }

                updateStateFromIo {
                    copy(entity = entity?.copy(isFavorite = !isFavorite))
                }
            }
        )
    }

    @AssistedFactory
    interface Factory {
        fun create(entity: FlightEntity): FlightDetailsViewModel
    }
}