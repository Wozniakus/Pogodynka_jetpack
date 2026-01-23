package com.example.pogodynkafrontend.ui.forecast

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadForecast()
    }

    when (state) {
        is ForecastUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ForecastUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text((state as ForecastUiState.Error).message)
            }
        }

        is ForecastUiState.Success -> {
            val forecast =
                (state as ForecastUiState.Success).forecast

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                item {
                    Text(
                        "Prognoza godzinowa",
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                items(forecast.hourly) {
                    Text(
                        "${it.timestamp} • ${it.temperatureC}°C"
                    )
                }

                item {
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "Prognoza dzienna",
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                items(forecast.daily) {
                    Text(
                        "${it.date} • ${it.minTemperatureC}°C / ${it.maxTemperatureC}°C"
                    )
                }
            }
        }
    }
}
