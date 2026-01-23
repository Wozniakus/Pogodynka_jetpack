package com.example.pogodynkafrontend.ui.navigation

sealed class Screen(val route: String) {

    object Auth : Screen("auth")
    object Weather : Screen("weather")
    object Forecast : Screen("forecast")
    object Alerts : Screen("alerts")
    object Map : Screen("map")
    object Profile : Screen("profile")
}
