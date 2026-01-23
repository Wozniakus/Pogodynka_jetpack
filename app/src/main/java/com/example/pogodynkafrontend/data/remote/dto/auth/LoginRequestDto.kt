package com.example.pogodynkafrontend.data.remote.dto.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequestDto(
    val username: String,
    val password: String
)
