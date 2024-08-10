package com.example.horoscopo_app.ui.horoscope.detail

import androidx.lifecycle.ViewModel
import com.example.horoscopo_app.ui.horoscope.detail.DetailState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel(){

    private var _state = MutableStateFlow<DetailState>(Loading)
    val state:StateFlow<DetailState> = _state
}