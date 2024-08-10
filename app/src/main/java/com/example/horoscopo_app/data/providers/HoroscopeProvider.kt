package com.example.horoscopo_app.data.providers

import com.example.horoscopo_app.domain.models.HoroscopeInfo
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Acuario
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Aries
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Cancer
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Capricornio
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Geminis
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Leo
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Libra
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Piscis
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Sagitario
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Scorpio
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Tauro
import com.example.horoscopo_app.domain.models.HoroscopeInfo.Virgo
import javax.inject.Inject


class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Piscis
        )
    }
}