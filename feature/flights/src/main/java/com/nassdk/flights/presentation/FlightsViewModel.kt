package com.nassdk.flights.presentation

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.FlightsFeature
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState
import javax.inject.Inject

class FlightsViewModel @Inject constructor() : BaseViewModel<FlightsViewState, FlightsViewEvent>(
    initialState = FlightsViewState()
) {
    override fun observe(event: FlightsViewEvent) = Unit

    override fun onCleared() {
        FlightsFeature.destroyModuleGraph()
        super.onCleared()
    }
}