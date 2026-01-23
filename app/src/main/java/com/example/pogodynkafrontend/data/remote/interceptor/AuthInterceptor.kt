package com.example.pogodynkafrontend.data.remote.interceptor

import com.example.pogodynkafrontend.data.local.TokenStore
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val tokenStore: TokenStore
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val token = tokenStore.get()

        val newRequest =
            if (token != null) {
                request.newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer $token"
                    )
                    .build()
            } else {
                request
            }

        return chain.proceed(newRequest)
    }
}
