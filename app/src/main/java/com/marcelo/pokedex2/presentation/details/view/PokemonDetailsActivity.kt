package com.marcelo.pokedex2.presentation.details.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import com.marcelo.pokedex2.mechanism.utils.EXTRA_ID
import kotlinx.android.synthetic.main.activity_pokemon_details.*
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

        receiveData()
    }

    private fun receiveData() {
        pokemonData = intent?.getSerializableExtra(EXTRA_ID) as Pokemon
        pokemonData.also {

            Glide.with(this).load(it.imageUrl).into(ivPokemon2)
            pokemonName.text = it.name

        }
    }

}