package com.nassdk.flights

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.presentation.FlightsViewModel
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState
import javax.inject.Inject
import javax.inject.Provider

class FlightsApiImpl @Inject constructor() : FlightsApi {

    @Inject lateinit var viewModelFactory: Provider<FlightsViewModel>

    override fun provideViewModel(): BaseViewModel<FlightsViewState, FlightsViewEvent> {
        return viewModelFactory.get()
    }
}