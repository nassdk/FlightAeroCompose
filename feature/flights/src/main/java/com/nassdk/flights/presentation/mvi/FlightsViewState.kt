package com.nassdk.flights.presentation.mvi

import com.nassdk.common.base.BaseViewState
import com.nassdk.common.helpers.ItemUi

data class FlightsViewState(
    val isLoading: Boolean,
    val content: List<ItemUi>,
) : BaseViewState {

//    override fun equals(other: Any?): Boolean {
//        return when {
//            javaClass != other?.javaClass -> false
//            else -> this === other
//        }
//    }
//
//    override fun hashCode(): Int {
//        var result = isLoading.hashCode()
//        result = 31 * result + content.hashCode()
//        return result
//    }

    companion object {

        fun provideInitialViewState(): FlightsViewState {
            return FlightsViewState(
                isLoading = false,
                content = emptyList()
            )
        }
    }
}