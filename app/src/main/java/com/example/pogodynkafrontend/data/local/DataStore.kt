package com.example.pogodynkafrontend.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenStore @Inject constructor() {

    private var token: String? = null

    fun save(token: String) {
        this.token = token
    }

    fun get(): String? = token

    fun clear() {
        token = null
    }

    fun isLoggedIn(): Boolean = token != null
}
