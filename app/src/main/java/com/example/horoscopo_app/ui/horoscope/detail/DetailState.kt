package com.example.horoscopo_app.ui.horoscope.detail

sealed class DetailState {
    data object Loading : DetailState()
    data class Error(val error: String) : DetailState()
    data class Success(val data: String) : DetailState()
}