package com.example.pogodynkafrontend.data.remote.dto.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponseDto(
    val token: String,
    val username: String
)
