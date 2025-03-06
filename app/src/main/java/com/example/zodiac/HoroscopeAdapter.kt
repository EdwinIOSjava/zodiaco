package com.example.zodiac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class HoroscopeAdapter(private var items: List<Horoscope>, val onClick : (Int)-> Unit) : Adapter<HoroscopeViewHolder>() {

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = items[position]
        holder.render(horoscope)

        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    //actualizamos los items
    fun updateItems(items: List<Horoscope>) {
        this.items = items
        notifyDataSetChanged()
    }
}


class HoroscopeViewHolder(view: View) : ViewHolder(view) {

    val iconImageView: ImageView = view.findViewById(R.id.iconImageView)
    val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    val dateTextView: TextView = view.findViewById(R.id.dateTextView)
// asignamos valores en el ViewHolder/  o la vista que queremos que se vea al hacer scroll.... a cada holder le asignaremos sus valores aqui
    fun render(horoscope: Horoscope) {
        iconImageView.setImageResource(horoscope.icon)
        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.dates)
    }
}