package com.example.pogodynkafrontend.data.remote.api

import com.example.pogodynkafrontend.data.remote.dto.forecast.ForecastResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {

    @GET("/forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): ForecastResponseDto
}
