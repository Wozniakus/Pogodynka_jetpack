package com.example.pogodynkafrontend.data.remote.dto.route

import com.example.pogodynkafrontend.data.remote.dto.weather.WeatherResponseDto
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SegmentWeatherDto(
    val startLat: Double,
    val startLon: Double,
    val endLat: Double,
    val endLon: Double,
    val riskLevel: String, // LOW / MEDIUM / HIGH
    val weather: WeatherResponseDto
)
