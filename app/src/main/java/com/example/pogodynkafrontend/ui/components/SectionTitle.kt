package com.example.pogodynkafrontend.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge
    )
}
