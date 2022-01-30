package com.nassdk.common.extensions

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.compose.composable
import com.nassdk.navigation.NavTarget

fun NavController.navigate(
    target: NavTarget,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    navigate(
        NavDeepLinkRequest.Builder
            .fromUri(
                uri = NavDestination.createRoute(
                    route = target.route
                ).toUri()
            ).build(),
        navOptions = navOptions,
        navigatorExtras = navigatorExtras
    )
}

@ExperimentalAnimationApi
fun NavGraphBuilder.aeroComposable(
    target: NavTarget,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit,
) {
    composable(
        route = target.route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = content
    )
}

