package com.example.pogodynkafrontend.data.remote.api

import com.example.pogodynkafrontend.data.remote.dto.alert.AlertResponseDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface AlertApi {

    @GET("/alerts")
    suspend fun getAlerts(): List<AlertResponseDto>

    @DELETE("/alerts/{id}")
    suspend fun deleteAlert(
        @Path("id") id: Long
    )
}
