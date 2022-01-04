package com.nassdk.aero

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nassdk.aero.mediators.MediatorManager
import com.nassdk.common.extensions.aeroComposable
import com.nassdk.common.extensions.composeViewModel
import com.nassdk.navigation.Screens
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
                route = Screens.Splash,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.splashMediator.getApi().provideViewModel()
                    }

                    SplashScreen(viewModel = viewModel)
                }
            )
        }
    )
}