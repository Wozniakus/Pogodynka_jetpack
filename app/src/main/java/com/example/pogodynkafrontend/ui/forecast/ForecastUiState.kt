package com.example.pogodynkafrontend.ui.forecast

import com.example.pogodynkafrontend.data.remote.dto.forecast.ForecastResponseDto

sealed class ForecastUiState {
    object Loading : ForecastUiState()
    data class Success(
        val forecast: ForecastResponseDto
    ) : ForecastUiState()
    data class Error(
        val message: String
    ) : ForecastUiState()
}
