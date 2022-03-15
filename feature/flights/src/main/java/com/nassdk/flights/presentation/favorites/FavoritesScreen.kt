package com.nassdk.flights.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.nassdk.common.base.BaseViewModel
import com.nassdk.common.extensions.navigate
import com.nassdk.flights.R
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewEvent
import com.nassdk.flights.presentation.favorites.mvi.FavoritesViewState
import com.nassdk.flights.presentation.favorites.views.ContentView
import com.nassdk.navigation.Screens
import com.nassdk.ui.kit.Toolbar
import com.nassdk.ui.theme.AeroTheme

@Composable
fun FavoritesScreen(
    viewModel: BaseViewModel<FavoritesViewState, FavoritesViewEvent>,
    navController: NavController
) {

    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {
            Toolbar(
                title = stringResource(id = R.string.favorites_title),
                startDrawableRes = R.drawable.icv_arrow_back,
                endDrawableRes = R.drawable.icv_filters,
                startButtonListener = {
                    navController.popBackStack()
                }
            )

            ContentView(
                content = viewState.flights,
                onFlightSelect = { entity ->
                    navController.currentBackStackEntry?.arguments?.putParcelable(
                        ARG_FLIGHT_ENTITY,
                        entity
                    )
                    navController.navigate(target = Screens.FlightDetails)
                }
            )
        }
    )
}

const val ARG_FLIGHT_ENTITY = "ARG_FLIGHT_ENTITY"