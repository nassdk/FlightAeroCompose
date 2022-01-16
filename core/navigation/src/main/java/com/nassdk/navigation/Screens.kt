package com.nassdk.navigation

sealed class Screens : NavTarget {

    object Splash : Screens() {
        override val route: String = "splash"
    }

    object Flow : Screens() {
        override val route: String = "flow"
    }

    object Flights : Screens() {
        override val route: String = "flights"
    }

    object Profile : Screens() {
        override val route: String = "profile"
    }

    object Settings : Screens() {
        override val route: String = "settings"
    }
}