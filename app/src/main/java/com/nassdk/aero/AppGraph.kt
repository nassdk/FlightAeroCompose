package com.nassdk.aero

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nassdk.aero.mediators.MediatorManager
import com.nassdk.common.extensions.aeroComposable
import com.nassdk.common.extensions.composeViewModel
import com.nassdk.flights.presentation.FlightsScreen
import com.nassdk.flow.presentation.FlowScreen
import com.nassdk.navigation.Screens
import com.nassdk.navigation.TransitionType
import com.nassdk.profile.ProfileScreen
import com.nassdk.splash.presentation.SplashScreen

@ExperimentalAnimationApi
@Composable
fun MainGraph() {

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
                target = Screens.Flow,
                transitionType = TransitionType.NONE,
                content = {
                    FlowScreen(
                        flowGraphBuilder = {
                            aeroComposable(
                                target = Screens.Flights,
                                transitionType = TransitionType.NONE,
                                content = {

                                    val viewModel = composeViewModel {
                                        MediatorManager.flightsMediator.getApi().provideViewModel()
                                    }

                                    FlightsScreen(viewModel = viewModel)
                                }
                            )

                            aeroComposable(
                                target = Screens.Profile,
                                transitionType = TransitionType.NONE,
                                content = { ProfileScreen() }
                            )
                        }
                    )
                }
            )
        }
    )
}