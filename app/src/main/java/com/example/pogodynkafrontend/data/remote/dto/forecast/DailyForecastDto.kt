package com.example.pogodynkafrontend.data.remote.dto.forecast

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyForecastDto(
    val date: String,
    val minTemperatureC: Float,
    val maxTemperatureC: Float
)
