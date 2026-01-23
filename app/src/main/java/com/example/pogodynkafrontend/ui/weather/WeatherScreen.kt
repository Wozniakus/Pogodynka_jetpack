package com.example.pogodynkafrontend.ui.weather

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pogodynkafrontend.data.remote.dto.weather.WeatherResponseDto

@Composable
fun WeatherScreen(
    onNavigateToForecast: () -> Unit,
    onNavigateToAlerts: () -> Unit,
    onNavigateToMap: () -> Unit,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadWeather()
    }

    when (state) {
        is WeatherUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is WeatherUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = (state as WeatherUiState.Error).message
                )
            }
        }

        is WeatherUiState.Success -> {
            WeatherContent(
                weather = (state as WeatherUiState.Success).weather,
                onNavigateToForecast = onNavigateToForecast,
                onNavigateToAlerts = onNavigateToAlerts,
                onNavigateToMap = onNavigateToMap
            )
        }
    }
}

@Composable
private fun WeatherContent(
    weather: WeatherResponseDto,
    onNavigateToForecast: () -> Unit,
    onNavigateToAlerts: () -> Unit,
    onNavigateToMap: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Temperatura: ${weather.temperatureC}°C",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))
        Text("Wiatr: ${weather.windKmH} km/h")
        Text("Opady: ${weather.precipitationMmH} mm/h")
        Text("Ciśnienie: ${weather.pressureHpa} hPa")
        Text("Widoczność: ${weather.visibilityM} m")

        Spacer(Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onNavigateToForecast
        ) {
            Text("Prognoza")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onNavigateToAlerts
        ) {
            Text("Alerty")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onNavigateToMap
        ) {
            Text("Mapa trasy")
        }
    }
}
