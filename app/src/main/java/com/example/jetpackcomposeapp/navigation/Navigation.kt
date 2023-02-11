package com.example.jetpackcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposeapp.screens.home.HomeScreen
import com.example.jetpackcomposeapp.screens.location.LocationScreen
import com.example.jetpackcomposeapp.screens.more.MoreScreen
import com.example.jetpackcomposeapp.screens.vehicle.VehicleScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Vehicle.route) {
            VehicleScreen()
        }
        composable(NavigationItem.Location.route) {
            LocationScreen()
        }
        composable(NavigationItem.More.route) {
            MoreScreen()
        }
    }
}