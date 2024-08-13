package com.example.horoscopo_app.domain.models

data class PredictionModel(
    val date: String,
    val horoscope: String,
    val icon: String,
    val id: Int,
    val sign: String
)