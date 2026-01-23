package com.example.pogodynkafrontend.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.pogodynkafrontend.ui.alert.AlertScreen
import com.example.pogodynkafrontend.ui.auth.AuthScreen
import com.example.pogodynkafrontend.ui.forecast.ForecastScreen
import com.example.pogodynkafrontend.ui.map.MapScreen
import com.example.pogodynkafrontend.ui.profile.ProfileScreen
import com.example.pogodynkafrontend.ui.weather.WeatherScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.Auth.route) {
            AuthScreen(
                onAuthSuccess = {
                    navController.navigate(Screen.Weather.route) {
                        popUpTo(Screen.Auth.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Weather.route) {
            WeatherScreen(
                onNavigateToForecast = {
                    navController.navigate(Screen.Forecast.route)
                },
                onNavigateToAlerts = {
                    navController.navigate(Screen.Alerts.route)
                },
                onNavigateToMap = {
                    navController.navigate(Screen.Map.route)
                }
            )
        }

        composable(Screen.Forecast.route) {
            ForecastScreen()
        }

        composable(Screen.Alerts.route) {
            AlertScreen()
        }

        composable(Screen.Map.route) {
            MapScreen()
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onLoggedOut = {
                    navController.navigate(Screen.Auth.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}
