package com.example.pogodynkafrontend.ui.forecast

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pogodynkafrontend.data.repository.ForecastRepository
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: ForecastRepository,
    private val locationClient: FusedLocationProviderClient
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<ForecastUiState>(ForecastUiState.Loading)
    val uiState = _uiState.asStateFlow()

    @SuppressLint("MissingPermission")
    fun loadForecast() {
        viewModelScope.launch {
            locationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        fetchForecast(
                            location.latitude,
                            location.longitude
                        )
                    } else {
                        _uiState.value =
                            ForecastUiState.Error("Brak lokalizacji")
                    }
                }
        }
    }

    private fun fetchForecast(
        lat: Double,
        lon: Double
    ) {
        viewModelScope.launch {
            try {
                val forecast =
                    repository.getForecast(lat, lon)
                _uiState.value =
                    ForecastUiState.Success(forecast)
            } catch (e: Exception) {
                _uiState.value =
                    ForecastUiState.Error(
                        e.message ?: "Błąd prognozy"
                    )
            }
        }
    }
}
