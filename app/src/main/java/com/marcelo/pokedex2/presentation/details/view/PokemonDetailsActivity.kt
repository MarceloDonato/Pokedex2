package com.marcelo.pokedex2.presentation.details.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import com.marcelo.pokedex2.domain.convertValue
import com.marcelo.pokedex2.mechanism.utils.EXTRA_ID
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.include_details_image.*
import kotlinx.android.synthetic.main.include_details_text.*
import kotlinx.android.synthetic.main.pokemon_item.view.*


class PokemonDetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, pokemon: Pokemon): Intent =
            Intent(context, PokemonDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, pokemon)
            }
    }

    private lateinit var pokemonData: Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
        clickListeners()
        receiveData()
    }

    private fun clickListeners() {
        back.setOnClickListener { finish() }
    }

    private fun receiveData() {
        pokemonData = intent?.getSerializableExtra(EXTRA_ID) as Pokemon
        pokemonData.also {

            Glide.with(this).load(it.imageUrl).into(ivPokemon2)
            pokemonName.text = it.name
            tvType1.text = it.types[0].name
            if (it.types.size > 1) {
                tvType2.text = it.types[1].name
            } else {
                tvType2.visibility = View.GONE
            }

            height.text = getString(R.string.pokemon_height, convertValue(it.height))
            weight.text = getString(R.string.pokemon_weight, convertValue(it.weight))

        }
    }

}