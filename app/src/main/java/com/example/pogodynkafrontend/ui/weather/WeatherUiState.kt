package com.example.pogodynkafrontend.ui.weather

import com.example.pogodynkafrontend.data.remote.dto.weather.WeatherResponseDto

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(
        val weather: WeatherResponseDto
    ) : WeatherUiState()
    data class Error(
        val message: String
    ) : WeatherUiState()
}
