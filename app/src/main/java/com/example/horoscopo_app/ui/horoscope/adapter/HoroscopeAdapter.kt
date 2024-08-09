package com.example.horoscopo_app.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.models.HoroscopeInfo

class  HoroscopeAdapter(private var items: List<HoroscopeInfo> = emptyList()) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(items[position])
    }

    fun updateList(list: List<HoroscopeInfo>){
        items = list
        notifyDataSetChanged()
    }
}