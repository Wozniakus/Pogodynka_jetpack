package com.example.pogodynkafrontend.ui.profile

sealed class ProfileUiState {
    object Idle : ProfileUiState()
    object LoggedOut : ProfileUiState()
}
