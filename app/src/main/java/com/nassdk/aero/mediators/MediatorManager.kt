package com.nassdk.aero.mediators

object MediatorManager {
    val splashMediator: SplashMediator by lazy { SplashMediator() }
    val flightsMediator: FlightsMediator by lazy { FlightsMediator() }
}