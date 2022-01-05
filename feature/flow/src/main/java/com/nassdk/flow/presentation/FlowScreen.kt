package com.nassdk.flow.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nassdk.flow.domain.TabItem
import com.nassdk.navigation.Screens
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.White

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FlowScreen(flowGraphBuilder: NavGraphBuilder.() -> Unit) {

    val navController = rememberAnimatedNavController()
    val navItems = arrayOf(TabItem.FLIGHTS, TabItem.PROFILE)
    val isDarkMode = isSystemInDarkTheme()

    val systemUiController = rememberSystemUiController()

    SideEffect(
        effect = {
            systemUiController.setSystemBarsColor(
                color = if (isDarkMode) White else White
            )
        }
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = AeroTheme.colors.secondaryBackground,
                content = {
                    navItems.forEach { target ->
                        BottomNavigationItem(
                            selected = false,
                            onClick = {
                                navController.navigate(target.route) {
                                    launchSingleTop = true
                                }
                            },
                            label = {
                                Text(text = stringResource(id = target.title))
                            },
                            icon = {
                                Image(
                                    painter = painterResource(id = target.icon),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            )
        },
        content = {

            AnimatedNavHost(
                navController = navController,
                startDestination = Screens.Flights.route,
                builder = flowGraphBuilder
            )
        }
    )
}