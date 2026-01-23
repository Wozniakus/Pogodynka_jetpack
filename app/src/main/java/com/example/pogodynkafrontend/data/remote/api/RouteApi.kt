package com.example.pogodynkafrontend.data.remote.api

import com.example.pogodynkafrontend.data.remote.dto.route.RouteWeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RouteApi {

    @GET("/route/weather")
    suspend fun getRouteWeather(
        @Query("startLat") startLat: Double,
        @Query("startLon") startLon: Double,
        @Query("endLat") endLat: Double,
        @Query("endLon") endLon: Double
    ): RouteWeatherResponseDto
}
