package com.nassdk.flights.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.nassdk.common.base.BaseViewModel
import com.nassdk.flights.presentation.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.mvi.FlightsViewState
import com.nassdk.flights.presentation.views.AppBar
import com.nassdk.flights.presentation.views.ContentView
import com.nassdk.ui.theme.AeroTheme

@Composable
fun FlightsScreen(viewModel: BaseViewModel<FlightsViewState, FlightsViewEvent>) {

    val screenState by viewModel.viewState.observeAsState(
        initial = FlightsViewState.provideInitialViewState()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            AppBar()

            ContentView(
                content = screenState.content,
                loadNextPage = {
                    viewModel.perform(viewEvent = FlightsViewEvent.LoadNextPage)
                }
            )
        }
    )
}