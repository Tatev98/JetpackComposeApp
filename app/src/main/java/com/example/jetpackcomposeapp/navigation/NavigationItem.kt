package com.example.jetpackcomposeapp.navigation

import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.navigation.Destinations.HOME_ROUTE
import com.example.jetpackcomposeapp.navigation.Destinations.LOCATION_ROUTE
import com.example.jetpackcomposeapp.navigation.Destinations.MORE_ROUTE
import com.example.jetpackcomposeapp.navigation.Destinations.VEHICLE_ROUTE


object Destinations {
    const val HOME_ROUTE = "home"
    const val VEHICLE_ROUTE = "vehicle"
    const val LOCATION_ROUTE = "location"
    const val MORE_ROUTE = "more"
}

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem(HOME_ROUTE, R.drawable.ic_home, "Home")
    object Vehicle : NavigationItem(VEHICLE_ROUTE, R.drawable.ic_car, "Vehicle")
    object Location : NavigationItem(LOCATION_ROUTE, R.drawable.ic_location, "Location")
    object More : NavigationItem(MORE_ROUTE, R.drawable.ic_more, "More")
}