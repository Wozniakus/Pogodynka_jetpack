package com.example.pogodynkafrontend.data.remote.dto.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponseDto(
    val lat: Double,
    val lon: Double,
    val temperatureC: Float,
    val precipitationMmH: Float,
    val windKmH: Float,
    val pressureHpa: Float,
    val visibilityM: Int,
    val timestamp: String
)
