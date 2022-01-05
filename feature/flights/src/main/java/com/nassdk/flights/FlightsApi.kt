package com.nassdk.flights

import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState

interface FlightsApi {

    fun provideViewModel(): BaseViewModel<FlightsViewState, FlightsViewEvent>
}