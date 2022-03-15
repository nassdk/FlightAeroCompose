package com.nassdk.flights.presentation.details.mvi

import com.nassdk.common.base.BaseViewEvent

sealed class FlightDetailsViewEvent : BaseViewEvent {
    object UpdateFavoritesState : FlightDetailsViewEvent()
}