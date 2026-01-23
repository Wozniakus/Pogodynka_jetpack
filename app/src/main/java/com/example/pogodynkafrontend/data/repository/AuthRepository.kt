package com.example.pogodynkafrontend.data.repository

import com.example.pogodynkafrontend.data.local.TokenStore
import com.example.pogodynkafrontend.data.remote.api.AuthApi
import com.example.pogodynkafrontend.data.remote.dto.auth.LoginRequestDto
import com.example.pogodynkafrontend.data.remote.dto.auth.RegisterRequestDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val tokenStore: TokenStore
) {

    suspend fun login(username: String, password: String) {
        val response = api.login(
            LoginRequestDto(username, password)
        )
        tokenStore.save(response.token)
    }

    suspend fun register(
        username: String,
        email: String,
        password: String
    ) {
        api.register(
            RegisterRequestDto(username, email, password)
        )
    }

    fun logout() {
        tokenStore.clear()
    }

    fun isLoggedIn(): Boolean =
        tokenStore.isLoggedIn()
}
