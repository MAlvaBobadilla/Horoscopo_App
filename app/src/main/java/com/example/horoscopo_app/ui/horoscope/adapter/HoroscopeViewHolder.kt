package com.example.horoscopo_app.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.data.models.HoroscopeInfo
import com.example.horoscopo_app.databinding.ItemHoroscopeBinding

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo){
        binding.imvHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.setText(horoscopeInfo.name)
    }

}