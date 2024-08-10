package com.example.horoscopo_app.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopo_app.data.providers.HoroscopeProvider
import com.example.horoscopo_app.domain.models.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(val horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //Para cargar un valor ni bien se inicie el view model
    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}