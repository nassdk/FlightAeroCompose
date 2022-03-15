package com.nassdk.aero

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nassdk.aero.mediators.MediatorManager
import com.nassdk.common.extensions.aeroComposable
import com.nassdk.common.extensions.composeViewModel
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.presentation.details.FlightDetailsScreen
import com.nassdk.flights.presentation.favorites.FavoritesScreen
import com.nassdk.flights.presentation.list.ARG_FLIGHT_ENTITY
import com.nassdk.flights.presentation.list.FlightsScreen
import com.nassdk.flow.presentation.FlowScreen
import com.nassdk.navigation.Screens
import com.nassdk.profile.domain.entity.SettingsBundle
import com.nassdk.profile.presentation.profile.ProfileScreen
import com.nassdk.profile.presentation.settings.SettingsScreen
import com.nassdk.splash.presentation.SplashScreen

@ExperimentalAnimationApi
@Composable
fun MainGraph(
    settingsState: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        builder = {

            aeroComposable(
                target = Screens.Splash,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.splashMediator.getApi().provideViewModel()
                    }

                    SplashScreen(viewModel = viewModel, navController = navController)
                }
            )

            aeroComposable(
                target = Screens.Settings,
                content = {
                    SettingsScreen(
                        navController = navController,
                        settingsState = settingsState,
                        onSettingsChanged = onSettingsChanged
                    )
                }
            )

            aeroComposable(
                target = Screens.Favorites,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.flightsMediator.getApi().provideFavoritesVM()
                    }

                    FavoritesScreen(navController = navController, viewModel = viewModel)
                }
            )

            aeroComposable(
                target = Screens.FlightDetails,
                content = {

                    val entity = navController.previousBackStackEntry
                        ?.arguments
                        ?.getParcelable<FlightEntity>(ARG_FLIGHT_ENTITY)
                        ?: return@aeroComposable

                    val viewModel = composeViewModel {
                        MediatorManager.flightsMediator.getApi().provideFlightDetailsVM(
                            entity = entity
                        )
                    }

                    FlightDetailsScreen(
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            )

            aeroComposable(
                target = Screens.Flow,
                content = {
                    FlowScreen(
                        isDarkMode = settingsState.isDarkMode,
                        flowGraphBuilder = {
                            aeroComposable(
                                target = Screens.Flights,
                                content = {

                                    val viewModel = composeViewModel {
                                        MediatorManager.flightsMediator.getApi().provideFlightsVM()
                                    }

                                    FlightsScreen(
                                        viewModel = viewModel,
                                        navController = navController
                                    )
                                }
                            )

                            aeroComposable(
                                target = Screens.Profile,
                                content = { ProfileScreen(navController = navController) }
                            )
                        }
                    )
                }
            )
        }
    )
}