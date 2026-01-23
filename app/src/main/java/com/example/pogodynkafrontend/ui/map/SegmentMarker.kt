package com.example.pogodynkafrontend.ui.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.pogodynkafrontend.data.remote.dto.route.SegmentWeatherDto
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun SegmentMarker(
    segment: SegmentWeatherDto
) {
    val markerState = remember {
        MarkerState(
            position = LatLng(
                segment.startLat,
                segment.startLon
            )
        )
    }

    Marker(
        state = markerState,
        title = "Ryzyko: ${segment.riskLevel}",
        snippet = "Temp: ${segment.weather.temperatureC}°C"
    )
}
