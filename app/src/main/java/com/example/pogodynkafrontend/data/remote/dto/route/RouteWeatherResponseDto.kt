package com.example.pogodynkafrontend.data.remote.dto.route

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteWeatherResponseDto(
    val segments: List<SegmentWeatherDto>
)
