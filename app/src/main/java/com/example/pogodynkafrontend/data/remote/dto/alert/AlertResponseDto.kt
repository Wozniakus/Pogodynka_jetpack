package com.example.pogodynkafrontend.data.remote.dto.alert

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlertResponseDto(
    val id: Long,
    val type: String,
    val threshold: Float,
    val active: Boolean
)
