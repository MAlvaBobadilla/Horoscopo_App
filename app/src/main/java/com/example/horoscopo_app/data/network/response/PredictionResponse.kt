package com.example.horoscopo_app.data.network.response

import com.example.horoscopo_app.domain.models.PredictionModel
import com.google.gson.annotations.SerializedName


data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            date = date,
            horoscope = horoscope,
            icon = icon,
            id = id,
            sign = sign
        )
    }
}
