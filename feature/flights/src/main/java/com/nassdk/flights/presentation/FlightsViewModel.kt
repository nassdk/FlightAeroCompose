package com.nassdk.flights.presentation

import com.nassdk.common.base.BaseViewModel
import com.nassdk.common.coroutines.CoroutinesDispatcherProvider
import com.nassdk.common.extensions.orZero
import com.nassdk.flights.FlightsFeature
import com.nassdk.flights.domain.repo.FlightsRepository
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState
import com.nassdk.flights.presentation.ui.FlightsUiBuilder
import javax.inject.Inject
import kotlinx.coroutines.delay

class FlightsViewModel @Inject constructor(
    private val uiBuilder: FlightsUiBuilder,
    private val repository: FlightsRepository,
    dispatcherProvider: CoroutinesDispatcherProvider,
) : BaseViewModel<FlightsViewState, FlightsViewEvent>(
    initialState = FlightsViewState.provideInitialViewState(),
    dispatcherProvider = dispatcherProvider
) {

    init {
        fetchFlights()
    }

    override fun observe(event: FlightsViewEvent) {
        when (event) {
            is FlightsViewEvent.LoadNextPage -> fetchFlights()
        }
    }

    private fun fetchFlights() {

        if (uiBuilder.shouldPaginate.not()) return

        if (uiBuilder.paginationState?.offset.orZero() == 0) {
            updateState {
                copy(isLoading = true)
            }
        }

        launchIOCoroutine {
            delay(timeMillis = 2000)

            val response = repository.getRealTimeFlights(
                offset = uiBuilder.paginationState?.offset.orZero()
            )

            uiBuilder.setPaginationData(entity = response.pagination)
            uiBuilder.addFlights(flights = response.flights)

            updateStateFromIo {
                copy(content = uiBuilder.items, isLoading = false)
            }
        }
    }

    override fun onCleared() {
        FlightsFeature.destroyModuleGraph()
        super.onCleared()
    }
}