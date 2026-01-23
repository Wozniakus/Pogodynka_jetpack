package com.example.pogodynkafrontend.ui.weather

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pogodynkafrontend.data.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationClient: FusedLocationProviderClient
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState = _uiState.asStateFlow()

    @SuppressLint("MissingPermission")
    fun loadWeather() {
        viewModelScope.launch {
            locationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        fetchWeather(
                            location.latitude,
                            location.longitude
                        )
                    } else {
                        _uiState.value =
                            WeatherUiState.Error("Brak lokalizacji")
                    }
                }
        }
    }

    private fun fetchWeather(
        lat: Double,
        lon: Double
    ) {
        viewModelScope.launch {
            try {
                val weather =
                    repository.getCurrentWeather(lat, lon)
                _uiState.value =
                    WeatherUiState.Success(weather)
            } catch (e: Exception) {
                _uiState.value =
                    WeatherUiState.Error(
                        e.message ?: "Błąd pogody"
                    )
            }
        }
    }
}
