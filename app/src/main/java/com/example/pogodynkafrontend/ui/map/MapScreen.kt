package com.example.pogodynkafrontend.ui.map

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    var startPoint by remember { mutableStateOf<LatLng?>(null) }
    var endPoint by remember { mutableStateOf<LatLng?>(null) }

    val cameraState = rememberCameraPositionState()

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraState,
        onMapClick = { latLng ->
            when {
                startPoint == null -> startPoint = latLng
                endPoint == null -> {
                    endPoint = latLng
                    viewModel.loadRoute(
                        startPoint!!.latitude,
                        startPoint!!.longitude,
                        endPoint!!.latitude,
                        endPoint!!.longitude
                    )
                }
                else -> {
                    startPoint = latLng
                    endPoint = null
                }
            }
        }
    ) {
        if (state is MapUiState.RouteLoaded) {
            val route =
                (state as MapUiState.RouteLoaded).route

            RouteOverlay(route)
            route.segments.forEach {
                SegmentMarker(it)
            }
        }
    }
}
