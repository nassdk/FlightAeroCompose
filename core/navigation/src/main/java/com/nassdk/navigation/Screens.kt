package com.nassdk.navigation

sealed class Screens {

    object Splash : NavTarget {
        override val route: String = "splash"
    }
}