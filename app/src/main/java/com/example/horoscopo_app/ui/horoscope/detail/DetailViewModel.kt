package com.example.horoscopo_app.ui.horoscope.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopo_app.domain.models.HoroscopeModel
import com.example.horoscopo_app.domain.usecase.GetPrediction
import com.example.horoscopo_app.ui.horoscope.detail.DetailState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPrediction: GetPrediction
) : ViewModel() {

    private var _state = MutableStateFlow<DetailState>(Loading)
    val state: StateFlow<DetailState> = _state

    lateinit var horoscope: HoroscopeModel

    fun getPredictionUseCase(sign: HoroscopeModel) {
        viewModelScope.launch {
            _state.value = DetailState.Loading
            val result = withContext(Dispatchers.IO) { getPrediction(sign = sign.name) }
            if (result != null) {
                _state.value = DetailState.Success(
                    img = result.icon,
                    title = result.sign,
                    prediction = result.horoscope
                )
            } else {
                _state.value = DetailState.Error(error = "Error al intentar cargar datos")
            }
        }
    }
}