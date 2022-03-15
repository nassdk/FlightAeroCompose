package com.nassdk.flights.presentation.list.mvi

import com.nassdk.common.base.BaseViewEvent

sealed class FlightsViewEvent : BaseViewEvent {
    object LoadNextPage : FlightsViewEvent()
}