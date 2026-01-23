package com.example.pogodynkafrontend.ui.alert

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pogodynkafrontend.data.remote.dto.alert.AlertResponseDto

@Composable
fun AlertList(
    alerts: List<AlertResponseDto>,
    onDelete: (Long) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(
            items = alerts,
            key = { it.id }
        ) { alert ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Typ: ${alert.type}",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Spacer(Modifier.height(4.dp))
                    Text("Próg: ${alert.threshold}")
                    Text(if (alert.active) "Aktywny" else "Nieaktywny")

                    Spacer(Modifier.height(8.dp))

                    TextButton(
                        onClick = { onDelete(alert.id) }
                    ) {
                        Text("Usuń")
                    }
                }
            }
        }
    }
}
