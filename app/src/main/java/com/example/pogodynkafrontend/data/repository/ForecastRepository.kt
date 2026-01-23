package com.example.pogodynkafrontend.data.repository

import com.example.pogodynkafrontend.data.remote.api.ForecastApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastRepository @Inject constructor(
    private val api: ForecastApi
) {

    suspend fun getForecast(
        lat: Double,
        lon: Double
    ) = api.getForecast(lat, lon)
}
