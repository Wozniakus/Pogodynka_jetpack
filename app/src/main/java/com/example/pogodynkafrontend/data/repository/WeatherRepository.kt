package com.example.pogodynkafrontend.data.repository

import com.example.pogodynkafrontend.data.remote.api.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ) = api.getCurrentWeather(lat, lon)
}
