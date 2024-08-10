package com.example.horoscopo_app.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.databinding.ItemHoroscopeBinding
import com.example.horoscopo_app.domain.models.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.imvHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.setText(horoscopeInfo.name)

        binding.parent.setOnClickListener { onItemSelected(horoscopeInfo) }
    }

}