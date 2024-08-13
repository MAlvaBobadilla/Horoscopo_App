package com.example.horoscopo_app.domain

import com.example.horoscopo_app.domain.models.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}