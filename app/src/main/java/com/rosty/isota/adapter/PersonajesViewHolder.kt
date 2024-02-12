package com.marisma.ejemplorecyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rosty.isota.Personajes
import com.rosty.isota.R
import com.rosty.isota.databinding.ItemPersonajeBinding

class PersonajesViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemPersonajeBinding.bind(view)

    fun render(equipoModel: Personajes, onClickListener: (Personajes) -> Unit){
        binding.tvEquipoName.text = equipoModel.personaje
        binding.tvEquipoLiga.text = equipoModel.elemento
        binding.tvEquipoEstadio.text = equipoModel.arma.toString()
        Glide.with(binding.ivEquipo.context).load(equipoModel.foto).into(binding.ivEquipo)

        val favIconResource = if (equipoModel.fav) R.drawable.sis else R.drawable.no
        binding.btnAction.setImageResource(favIconResource)

        binding.btnAction.setOnClickListener {
            // Cambiar el estado de favorito de la foto
            equipoModel.fav = !equipoModel.fav
            // Cambiar la imagen de ivFav según el estado de favorito
            val newFavIconResource = if (equipoModel.fav) R.drawable.sis else R.drawable.no
            // Actualizar la imagen de ivFav
            binding.btnAction.setImageResource(newFavIconResource)

            // Notificar al adaptador que los datos han cambiado
            onClickListener(equipoModel)
        }
        /*
        binding.ivEquipo.setOnClickListener{
            Toast.makeText(
                binding.ivEquipo.context,
                equipoModel.equipo,
                Toast.LENGTH_SHORT
            ).show()
        }
        itemView.setOnClickListener{
            Toast.makeText(
                binding.ivEquipo.context,
                equipoModel.estadio,
                Toast.LENGTH_SHORT
            ).show()
        }*/
        itemView.setOnClickListener{onClickListener(equipoModel)}
    }
}