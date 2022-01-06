package com.nassdk.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nassdk.common.base.BaseViewModel
import com.nassdk.navigation.Screens
import com.nassdk.splash.R
import com.nassdk.splash.presentation.mvi.SplashViewEvent
import com.nassdk.splash.presentation.mvi.SplashViewState
import com.nassdk.ui.theme.AeroTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: BaseViewModel<SplashViewState, SplashViewEvent>,
    navController: NavController,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        contentAlignment = Alignment.Center,
        content = {

            Image(
                painter = painterResource(id = R.drawable.ic_logo_big),
                contentDescription = null
            )

            CircularProgressIndicator(
                strokeWidth = 3.dp,
                color = AeroTheme.colors.spinnerColor,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 28.dp)
                    .size(size = 28.dp)
            )
        }
    )

    LaunchedEffect(
        key1 = Unit, block = {
            delay(2000)
            navController.navigate(
                route = Screens.Flow.route,
                builder = {
                    popUpTo(
                        route = Screens.Splash.route, popUpToBuilder = {
                            inclusive = true
                        }
                    )
                }
            )
        }
    )
}