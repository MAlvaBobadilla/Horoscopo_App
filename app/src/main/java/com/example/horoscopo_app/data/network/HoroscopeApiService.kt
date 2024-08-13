package com.example.horoscopo_app.data.network

import com.example.horoscopo_app.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}/")
    suspend fun getHoroscopeInfo(@Path("sign") sign: String): PredictionResponse
}