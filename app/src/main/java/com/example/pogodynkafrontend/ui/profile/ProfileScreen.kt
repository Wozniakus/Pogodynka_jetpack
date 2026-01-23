package com.example.pogodynkafrontend.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileScreen(
    onLoggedOut: () -> Unit,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(state) {
        if (state is ProfileUiState.LoggedOut) {
            onLoggedOut()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Profil użytkownika",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.logout() }
        ) {
            Text("Wyloguj się")
        }
    }
}
