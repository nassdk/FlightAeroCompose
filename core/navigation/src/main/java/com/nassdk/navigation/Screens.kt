package com.nassdk.navigation

sealed class Screens {

    object Splash : NavTarget {
        override val route: String = "splash"
    }

    object Flow : NavTarget {
        override val route: String = "flow"
    }

    object Flights : NavTarget {
        override val route: String = "flights"
    }

    object Profile : NavTarget {
        override val route: String = "profile"
    }
}