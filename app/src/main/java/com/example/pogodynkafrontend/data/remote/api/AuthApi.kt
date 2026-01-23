package com.example.pogodynkafrontend.data.remote.api

import com.example.pogodynkafrontend.data.remote.dto.auth.LoginRequestDto
import com.example.pogodynkafrontend.data.remote.dto.auth.LoginResponseDto
import com.example.pogodynkafrontend.data.remote.dto.auth.RegisterRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/auth/login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): LoginResponseDto

    @POST("/auth/register")
    suspend fun register(
        @Body request: RegisterRequestDto
    )
}
