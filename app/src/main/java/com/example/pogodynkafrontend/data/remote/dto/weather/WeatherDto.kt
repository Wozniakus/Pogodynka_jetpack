package com.example.pogodynkafrontend.data.remote.dto.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
    val temperature: Double,
    val pressure: Double,
    val humidity: Double,
    val description: String
)
