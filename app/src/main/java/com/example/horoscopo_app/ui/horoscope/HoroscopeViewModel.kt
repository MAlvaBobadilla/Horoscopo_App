package com.example.horoscopo_app.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopo_app.data.models.HoroscopeInfo
import com.example.horoscopo_app.data.models.HoroscopeInfo.Piscis
import com.example.horoscopo_app.data.models.HoroscopeInfo.Tauro
import com.example.horoscopo_app.data.models.HoroscopeInfo.Aries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //Para cargar un valor ni bien se inicie el view model
    init {
        _horoscope.value = listOf(Aries, Tauro, Piscis)
    }

}