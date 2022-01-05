package com.nassdk.flow.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nassdk.flow.R
import com.nassdk.navigation.Screens

enum class TabItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
) {
    FLIGHTS(
        route = Screens.Flights.route,
        icon = R.drawable.icv_flights_tab,
        title = R.string.flow_tab_flights_title
    ),
    PROFILE(
        route = Screens.Profile.route,
        icon = R.drawable.icv_profile_tab,
        title = R.string.flow_tab_profile_title
    );
}