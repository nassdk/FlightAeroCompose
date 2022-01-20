package com.nassdk.aero

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nassdk.aero.mediators.MediatorManager
import com.nassdk.common.extensions.aeroComposable
import com.nassdk.common.extensions.composeViewModel
import com.nassdk.flightdetails.presentation.FlightDetailsScreen
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.presentation.ARG_FLIGHT_ENTITY
import com.nassdk.flights.presentation.FlightsScreen
import com.nassdk.flow.presentation.FlowScreen
import com.nassdk.navigation.Screens
import com.nassdk.navigation.TransitionType
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
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        builder = {

            aeroComposable(
                target = Screens.Splash,
                transitionType = TransitionType.NONE,
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
                target = Screens.FlightDetails,
                content = {
                    val entity = navController.previousBackStackEntry
                        ?.arguments
                        ?.getParcelable<FlightEntity>(ARG_FLIGHT_ENTITY) ?: return@aeroComposable

                    val mappedEntity = MediatorManager.flightDetailsMediator.mapFlightEntity(
                        entity = entity
                    )

                    FlightDetailsScreen(
                        entity = mappedEntity,
                        navController = navController
                    )
                }
            )

            aeroComposable(
                target = Screens.Flow,
                transitionType = TransitionType.NONE,
                content = {
                    FlowScreen(
                        isDarkMode = settingsState.isDarkMode,
                        flowGraphBuilder = {
                            aeroComposable(
                                target = Screens.Flights,
                                transitionType = TransitionType.NONE,
                                content = {

                                    val viewModel = composeViewModel {
                                        MediatorManager.flightsMediator.getApi().provideViewModel()
                                    }

                                    FlightsScreen(
                                        viewModel = viewModel,
                                        navController = navController
                                    )
                                }
                            )

                            aeroComposable(
                                target = Screens.Profile,
                                transitionType = TransitionType.NONE,
                                content = { ProfileScreen(navController = navController) }
                            )
                        }
                    )
                }
            )
        }
    )
}