package com.example.pogodynkafrontend.di

import com.example.pogodynkafrontend.data.remote.api.*
import com.example.pogodynkafrontend.data.remote.interceptor.AuthInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://10.0.2.2:8080"

    // ---------- Moshi ----------

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    // ---------- OkHttp ----------

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    // ---------- Retrofit ----------

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )
            .build()

    // ---------- APIs ----------

    @Provides
    fun provideAuthApi(
        retrofit: Retrofit
    ): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit
    ): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideForecastApi(
        retrofit: Retrofit
    ): ForecastApi =
        retrofit.create(ForecastApi::class.java)

    @Provides
    fun provideAlertApi(
        retrofit: Retrofit
    ): AlertApi =
        retrofit.create(AlertApi::class.java)

    @Provides
    fun provideRouteApi(
        retrofit: Retrofit
    ): RouteApi =
        retrofit.create(RouteApi::class.java)
}
