package com.example.pogodynkafrontend.ui.profile

import androidx.lifecycle.ViewModel
import com.example.pogodynkafrontend.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<ProfileUiState>(ProfileUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun logout() {
        authRepository.logout()
        _uiState.value = ProfileUiState.LoggedOut
    }
}
