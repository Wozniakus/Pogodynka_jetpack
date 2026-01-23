package com.example.pogodynkafrontend.data.remote.dto.weather

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyForecastResponseDto(
    val items: List<WeatherResponseDto>
)
