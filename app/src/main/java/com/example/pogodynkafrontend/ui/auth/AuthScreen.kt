package com.example.pogodynkafrontend.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    onAuthSuccess: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) }

    LaunchedEffect(uiState) {
        if (uiState is AuthUiState.Success) {
            onAuthSuccess()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (isLogin) "Logowanie" else "Rejestracja",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nazwa użytkownika") },
            modifier = Modifier.fillMaxWidth()
        )

        if (!isLogin) {
            Spacer(Modifier.height(8.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Hasło") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (isLogin) {
                    viewModel.login(username, password)
                } else {
                    viewModel.register(username, email, password)
                }
            }
        ) {
            Text(if (isLogin) "Zaloguj" else "Zarejestruj")
        }

        Spacer(Modifier.height(8.dp))

        TextButton(
            onClick = { isLogin = !isLogin }
        ) {
            Text(
                if (isLogin)
                    "Nie masz konta? Zarejestruj się"
                else
                    "Masz konto? Zaloguj się"
            )
        }

        if (uiState is AuthUiState.Loading) {
            Spacer(Modifier.height(16.dp))
            CircularProgressIndicator()
        }

        if (uiState is AuthUiState.Error) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = (uiState as AuthUiState.Error).message,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}
