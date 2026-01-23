package com.example.pogodynkafrontend.data.remote.dto.forecast

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastResponseDto(
    val hourly: List<HourlyForecastDto>,
    val daily: List<DailyForecastDto>
)
