package com.marcelo.pokedex2.presentation.details.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.pokedex2.R


class PokemonDetails : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, PokemonDetails::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
    }
}