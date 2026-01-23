package com.example.pogodynkafrontend.ui.alert

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AlertScreen(
    viewModel: AlertViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAlerts()
    }

    when (state) {
        is AlertUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is AlertUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text((state as AlertUiState.Error).message)
            }
        }

        is AlertUiState.Success -> {
            val success = state as AlertUiState.Success

            Column {
                Text(
                    "Aktywne alerty",
                    style = MaterialTheme.typography.titleLarge
                )

                AlertList(
                    alerts = success.active,
                    onDelete = viewModel::deleteAlert
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    "Nieaktywne alerty",
                    style = MaterialTheme.typography.titleLarge
                )

                AlertList(
                    alerts = success.inactive,
                    onDelete = viewModel::deleteAlert
                )
            }
        }
    }
}
