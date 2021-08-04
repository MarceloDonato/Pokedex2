package com.marcelo.presentation.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.pokedex2.R
import com.marcelo.presentation.base.BaseRecyclerAdapter

class PokemondetailsRecyclerAdapter :
    BaseRecyclerAdapter<String?, PokemondetailsRecyclerAdapter.ViewHolder>() {


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        mData[position]?.let { viewHolder.bind(it, position) }
    }


    override fun validateDate() = false


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            (R.layout.itens_details_rv), viewGroup,
            false
        )
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: String, position: Int) {
            itemView.apply {

            }
        }
    }

}