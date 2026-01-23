package com.example.pogodynkafrontend.data.repository

import com.example.pogodynkafrontend.data.remote.api.RouteApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RouteRepository @Inject constructor(
    private val api: RouteApi
) {

    suspend fun getRouteWeather(
        startLat: Double,
        startLon: Double,
        endLat: Double,
        endLon: Double
    ) = api.getRouteWeather(
        startLat,
        startLon,
        endLat,
        endLon
    )
}
