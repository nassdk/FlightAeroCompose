package com.nassdk.aero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Surface
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.FlightAeroTheme
import javax.inject.Inject

class AppActivity : ComponentActivity() {

    @Inject lateinit var viewModel: AppViewModel

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        AppDelegate.app.appComponent.inject(app = this)
        super.onCreate(savedInstanceState)

        setContent {

            FlightAeroTheme(
                darkTheme = isSystemInDarkTheme(),
                content = {
                    Surface(
                        color = AeroTheme.colors.primaryBackground,
                        content = {
                            MainGraph()
                        }
                    )
                }
            )
        }
    }
}