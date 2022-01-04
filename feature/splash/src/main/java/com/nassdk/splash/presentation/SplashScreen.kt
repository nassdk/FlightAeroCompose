package com.nassdk.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.nassdk.common.base.BaseViewModel
import com.nassdk.splash.R
import com.nassdk.splash.presentation.model.SplashViewEvent
import com.nassdk.splash.presentation.model.SplashViewState
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.dimen_32

@Composable
fun SplashScreen(viewModel: BaseViewModel<SplashViewState, SplashViewEvent>) {

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
                color = AeroTheme.colors.spinnerColor,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = dimen_32)
                    .size(size = dimen_32)
            )
        }
    )

}