package com.nassdk.flights.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState
import com.nassdk.ui.theme.AeroTheme

@Composable
fun FlightsScreen(viewModel: BaseViewModel<FlightsViewState, FlightsViewEvent>) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        contentAlignment = Alignment.Center,
        content = {
            Text(text = "Flights")
        }
    )
}