package com.example.pogodynkafrontend.ui.map

import androidx.compose.runtime.Composable
import com.example.pogodynkafrontend.data.remote.dto.route.RouteWeatherResponseDto
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline

@Composable
fun RouteOverlay(
    route: RouteWeatherResponseDto
) {
    route.segments.forEach { segment ->
        Polyline(
            points = listOf(
                LatLng(segment.startLat, segment.startLon),
                LatLng(segment.endLat, segment.endLon)
            )
        )
    }
}
