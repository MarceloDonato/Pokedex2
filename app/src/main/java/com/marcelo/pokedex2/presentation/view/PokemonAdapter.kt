package com.marcelo.pokedex2.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import com.marcelo.pokedex2.presentation.base.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.pokemon_item.view.*


class PokemonAdapter :
    BaseRecyclerAdapter<Pokemon?, PokemonAdapter.ViewHolder>() {


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        mData[position]?.let { viewHolder.bind(it, position) }

    }

    override fun validateDate() = false

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            (R.layout.pokemon_item), viewGroup,
            false
        )
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon, position: Int) {

            itemView.apply {
                Glide.with(itemView.context).load(pokemon.imageUrl).into(ivPokemon)
                tvName.text = pokemon.formattedName

                container.setOnClickListener {
                    onItemClickListener?.invoke(pokemon)
                }


            }
        }
    }
}