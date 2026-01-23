package com.example.pogodynkafrontend.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyView(
    message: String,
    actionText: String? = null,
    onAction: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(message)

            if (actionText != null && onAction != null) {
                Spacer(Modifier.height(8.dp))
                TextButton(onClick = onAction) {
                    Text(actionText)
                }
            }
        }
    }
}
