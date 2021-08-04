package com.marcelo.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)

            val tvName = findViewById<TextView>(R.id.tvName)

            itemView.apply {

                item?.let {
                    Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)

                    tvName.text = item.formattedName

                    container.setOnClickListener {

                    }

                }
            }

        }
    }

    fun validateDate() = false
}