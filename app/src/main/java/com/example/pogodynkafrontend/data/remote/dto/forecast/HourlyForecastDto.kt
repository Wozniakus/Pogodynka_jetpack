package com.example.pogodynkafrontend.data.remote.dto.forecast

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyForecastDto(
    val timestamp: String,
    val temperatureC: Float,
    val precipitationMmH: Float,
    val windKmH: Float
)
