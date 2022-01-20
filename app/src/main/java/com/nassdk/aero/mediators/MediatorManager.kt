package com.nassdk.aero.mediators

object MediatorManager {
    val networkMediator: NetworkMediator by lazy { NetworkMediator() }
    val splashMediator: SplashMediator by lazy { SplashMediator() }
    val flightsMediator: FlightsMediator by lazy { FlightsMediator() }
    val flightDetailsMediator: FlightDetailsMediator by lazy { FlightDetailsMediator() }
}