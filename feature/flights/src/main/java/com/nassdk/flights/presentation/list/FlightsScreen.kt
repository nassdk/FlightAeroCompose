package com.nassdk.flights.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nassdk.common.base.BaseViewModel
import com.nassdk.common.extensions.navigate
import com.nassdk.flights.presentation.list.mvi.FlightsViewEvent
import com.nassdk.flights.presentation.list.mvi.FlightsViewState
import com.nassdk.flights.presentation.list.views.AppBar
import com.nassdk.flights.presentation.list.views.ContentView
import com.nassdk.flights.presentation.list.views.LoadingScreen
import com.nassdk.navigation.Screens
import com.nassdk.ui.theme.AeroTheme

@Composable
fun FlightsScreen(
    viewModel: BaseViewModel<FlightsViewState, FlightsViewEvent>,
    navController: NavController,
) {

    val screenState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            AppBar()

            if (screenState.isLoading) {
                LoadingScreen()
            }

            if (screenState.isLoading.not()) {
                ContentView(
                    content = screenState.content,
                    loadNextPage = {
                        viewModel.perform(viewEvent = FlightsViewEvent.LoadNextPage)
                    },
                    onFlightSelect = { entity ->
                        navController.currentBackStackEntry?.arguments?.putParcelable(
                            ARG_FLIGHT_ENTITY,
                            entity
                        )
                        navController.navigate(target = Screens.FlightDetails)
                    }
                )
            }
        }
    )
}

const val ARG_FLIGHT_ENTITY = "ARG_FLIGHT_ENTITY"