package com.example.pogodynkafrontend.data.remote.api

import com.example.pogodynkafrontend.data.remote.dto.weather.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/weather/current")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): WeatherResponseDto
}
