package com.example.horoscopo_app.ui.horoscope.detail

sealed class DetailState {
    data object Loading : DetailState()
    data class Error(val error: String) : DetailState()
    data class Success(val img: String, val title: String, val prediction: String) : DetailState()
}