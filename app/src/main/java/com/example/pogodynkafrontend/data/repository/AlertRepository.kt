package com.example.pogodynkafrontend.data.repository

import com.example.pogodynkafrontend.data.remote.api.AlertApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlertRepository @Inject constructor(
    private val api: AlertApi
) {

    suspend fun getAlerts() =
        api.getAlerts()

    suspend fun deleteAlert(id: Long) =
        api.deleteAlert(id)
}
