package com.example.pogodynkafrontend.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pogodynkafrontend.data.repository.RouteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val routeRepository: RouteRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<MapUiState>(MapUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun loadRoute(
        startLat: Double,
        startLon: Double,
        endLat: Double,
        endLon: Double
    ) {
        viewModelScope.launch {
            _uiState.value = MapUiState.Loading

            runCatching {
                routeRepository.getRouteWeather(
                    startLat, startLon, endLat, endLon
                )
            }.onSuccess { route ->
                _uiState.value =
                    MapUiState.RouteLoaded(route)
            }.onFailure {
                _uiState.value =
                    MapUiState.Error(
                        it.message ?: "Błąd trasy"
                    )
            }
        }
    }
}
