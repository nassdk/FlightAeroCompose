package com.nassdk.common.extensions

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.nassdk.navigation.NavTarget
import com.nassdk.navigation.TransitionType

private const val ANIMATION_DURATION = 350
private const val ANIMATION_OFFSET = 1000

@ExperimentalAnimationApi
fun NavGraphBuilder.aeroComposable(
    target: NavTarget,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    transitionType: TransitionType = TransitionType.HORIZONTAL,
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = target.route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = { getEnterTransition(type = transitionType) },
        exitTransition = { getPopExitTransition(type = transitionType) },
        popEnterTransition = null,
        popExitTransition = null,
        content = content
    )
}

private fun getEnterTransition(type: TransitionType): EnterTransition? {

    return when (type) {
        TransitionType.HORIZONTAL -> {
            slideInHorizontally(
                initialOffsetX = { ANIMATION_OFFSET },
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        }

        TransitionType.VERTICAL -> {
            slideInVertically(
                initialOffsetY = { ANIMATION_OFFSET },
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        }

        else -> null
    }
}

private fun getPopExitTransition(type: TransitionType): ExitTransition? {

    return when (type) {
        TransitionType.HORIZONTAL -> {
            slideOutHorizontally(
                targetOffsetX = { ANIMATION_OFFSET },
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        }

        TransitionType.VERTICAL -> {
            slideOutVertically(
                targetOffsetY = { ANIMATION_OFFSET },
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        }

        else -> null
    }
}

