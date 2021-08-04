package com.marcelo.pokedex2.presentation.details.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.pokedex2.R


class PokemonDetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, PokemonDetailsActivity::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
    }
}