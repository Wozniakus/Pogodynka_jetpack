package com.example.pogodynkafrontend.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pogodynkafrontend.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            try {
                repository.login(username, password)
                _uiState.value = AuthUiState.Success
            } catch (e: HttpException) {
                _uiState.value =
                    AuthUiState.Error("Błąd logowania")
            } catch (e: Exception) {
                _uiState.value =
                    AuthUiState.Error(e.message ?: "Nieznany błąd")
            }
        }
    }

    fun register(
        username: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            try {
                repository.register(username, email, password)
                _uiState.value = AuthUiState.Success
            } catch (e: HttpException) {
                _uiState.value =
                    AuthUiState.Error("Błąd rejestracji")
            } catch (e: Exception) {
                _uiState.value =
                    AuthUiState.Error(e.message ?: "Nieznany błąd")
            }
        }
    }
}
