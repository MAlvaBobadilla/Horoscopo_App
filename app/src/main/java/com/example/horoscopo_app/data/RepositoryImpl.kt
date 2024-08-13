package com.example.horoscopo_app.data

import android.util.Log
import com.example.horoscopo_app.data.network.HoroscopeApiService
import com.example.horoscopo_app.data.network.response.PredictionResponse
import com.example.horoscopo_app.domain.Repository
import com.example.horoscopo_app.domain.models.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: HoroscopeApiService
) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Petición a Retrofit
        runCatching {
            apiService.getHoroscopeInfo(sign)
        }
            .onSuccess<PredictionResponse> { return it.toDomain() }
            .onFailure<PredictionResponse> { Log.i("Aviso", "Error de Servicio: ${it.message}") }

        return null
    }
}