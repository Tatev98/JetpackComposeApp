package com.example.jetpackcomposeapp.model.navigation

import com.example.jetpackcomposeapp.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Vehicle : NavigationItem("vehicle", R.drawable.ic_car,"Vehicle")
    object Location : NavigationItem("location", R.drawable.ic_location, "Location")
    object More : NavigationItem("more", R.drawable.ic_more, "More")
}