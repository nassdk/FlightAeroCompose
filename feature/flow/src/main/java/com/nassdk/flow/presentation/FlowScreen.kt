package com.nassdk.flow.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
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

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
                            selected = currentRoute == target.route,
                            selectedContentColor = AeroTheme.colors.tintPrimary,
                            unselectedContentColor = AeroTheme.colors.tintSecondary,
                            alwaysShowLabel = true,
                            onClick = {
                                navController.navigate(
                                    route = target.route, builder = {
                                        navController.graph.startDestinationRoute?.let { route ->
                                            popUpTo(
                                                route = route, popUpToBuilder = {
                                                    saveState = true
                                                }
                                            )
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                )
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
        content = { padding ->

            AnimatedNavHost(
                navController = navController,
                startDestination = Screens.Flights.route,
                modifier = Modifier.padding(paddingValues = padding),
                builder = flowGraphBuilder
            )
        }
    )
}