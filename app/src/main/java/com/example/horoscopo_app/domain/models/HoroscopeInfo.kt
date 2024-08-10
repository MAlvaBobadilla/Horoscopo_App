package com.example.horoscopo_app.domain.models

import com.example.horoscopo_app.R

//data class HoroscopeInfo(
//    val id: Int,
//    val icon: String,
//    val name: String
//)

sealed class HoroscopeInfo(val img: Int, val name: Int) {
    data object Aries : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.aries)
    data object Tauro : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.taurus)
    data object Geminis : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.gemini)
    data object Cancer : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.cancer)
    data object Leo : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.leo)
    data object Virgo : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.virgo)
    data object Libra : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.libra)
    data object Scorpio : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.scorpio)
    data object Sagitario :
        HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.sagittarius)

    data object Capricornio :
        HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.capricorn)

    data object Acuario : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.aquarius)
    data object Piscis : HoroscopeInfo(img = R.drawable.ic_horoscope, name = R.string.pisces)
}