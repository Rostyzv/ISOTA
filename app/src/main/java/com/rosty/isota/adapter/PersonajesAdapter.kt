package com.marisma.ejemplorecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rosty.isota.Personajes
import com.rosty.isota.R

class PersonajesAdapter(private val equiposLista:List<Personajes>, private val onClickListener: (Personajes) -> Unit) : RecyclerView.Adapter<PersonajesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajesViewHolder(layoutInflater.inflate(R.layout.item_personaje,parent,false))
    }
    /** retornamos el tamaño de la lista del provider*/
    override fun getItemCount(): Int = equiposLista.size

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        holder.render(equiposLista[position], onClickListener)

    }

}