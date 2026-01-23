package com.example.pogodynkafrontend.ui.alert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pogodynkafrontend.data.remote.dto.alert.AlertResponseDto
import com.example.pogodynkafrontend.data.repository.AlertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class AlertViewModel @Inject constructor(
    private val repository: AlertRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<AlertUiState>(AlertUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadAlerts() {
        viewModelScope.launch {
            _uiState.value = AlertUiState.Loading

            runCatching {
                repository.getAlerts()
            }.onSuccess { alerts: List<AlertResponseDto> ->
                val active = alerts.filter { it.active }
                val inactive = alerts.filterNot { it.active }

                _uiState.value =
                    AlertUiState.Success(
                        active = active,
                        inactive = inactive
                    )
            }.onFailure { error ->
                if (error is HttpException && error.code() == 401) {
                    _uiState.value =
                        AlertUiState.Error("Sesja wygasła")
                } else {
                    _uiState.value =
                        AlertUiState.Error(
                            error.message ?: "Błąd alertów"
                        )
                }
            }
        }
    }

    fun deleteAlert(id: Long) {
        viewModelScope.launch {
            repository.deleteAlert(id)
            loadAlerts()
        }
    }
}
