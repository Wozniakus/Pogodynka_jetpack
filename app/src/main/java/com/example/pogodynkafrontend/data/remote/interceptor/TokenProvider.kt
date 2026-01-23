package com.example.pogodynkafrontend.data.remote.interceptor

interface TokenProvider {
    fun getToken(): String?
}
