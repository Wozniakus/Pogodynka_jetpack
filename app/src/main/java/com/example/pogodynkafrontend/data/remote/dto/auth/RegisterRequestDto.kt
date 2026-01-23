package com.example.pogodynkafrontend.data.remote.dto.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterRequestDto(
    val username: String,
    val email: String,
    val password: String
)
