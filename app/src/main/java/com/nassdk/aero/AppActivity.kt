package com.nassdk.aero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.FlightAeroTheme
import com.nassdk.ui.theme.White_F1F1F1
import javax.inject.Inject

class AppActivity : ComponentActivity() {

    @Inject lateinit var viewModel: AppViewModel

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        AppDelegate.app.appComponent.inject(app = this)
        super.onCreate(savedInstanceState)

        setContent {

            val isDarkMode = isSystemInDarkTheme()

            FlightAeroTheme(
                darkTheme = isDarkMode,
                content = {
                    val systemUiController = rememberSystemUiController()

                    SideEffect(
                        effect = {
                            systemUiController.setSystemBarsColor(
                                color = if (isDarkMode) White_F1F1F1 else White_F1F1F1
                            )
                        }
                    )

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