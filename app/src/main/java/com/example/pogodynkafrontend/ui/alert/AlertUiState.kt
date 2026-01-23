package com.example.pogodynkafrontend.ui.alert

import com.example.pogodynkafrontend.data.remote.dto.alert.AlertResponseDto

sealed class AlertUiState {
    object Loading : AlertUiState()

    data class Success(
        val active: List<AlertResponseDto>,
        val inactive: List<AlertResponseDto>
    ) : AlertUiState()

    data class Error(val message: String) : AlertUiState()
}
