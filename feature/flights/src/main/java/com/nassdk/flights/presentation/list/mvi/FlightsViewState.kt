package com.nassdk.flights.presentation.list.mvi

import androidx.compose.runtime.mutableStateListOf
import com.nassdk.common.base.BaseViewState
import com.nassdk.common.helpers.ItemUi

data class FlightsViewState(
    val isLoading: Boolean,
    val content: List<ItemUi>,
    val error: String
) : BaseViewState {

    companion object {

        fun provideInitialViewState(): FlightsViewState {
            return FlightsViewState(
                isLoading = false,
                content = mutableStateListOf(),
                error = ""
            )
        }
    }
}