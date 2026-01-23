package com.example.pogodynkafrontend.ui.map

import com.example.pogodynkafrontend.data.remote.dto.route.RouteWeatherResponseDto

sealed class MapUiState {
    object Idle : MapUiState()
    object Loading : MapUiState()

    data class RouteLoaded(
        val route: RouteWeatherResponseDto
    ) : MapUiState()

    data class Error(val message: String) : MapUiState()
}
