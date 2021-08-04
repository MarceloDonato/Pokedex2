package com.marcelo.pokedex2.presentation.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import com.marcelo.pokedex2.presentation.view.viewmodel.PokemonViewModel
import com.marcelo.pokedex2.presentation.view.viewmodel.PokemonViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val adapterList: PokemonAdapter by lazy {
        PokemonAdapter()
    }


    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {

        loader_pokemon.visibility = VISIBLE

        adapterList.data = pokemons.toMutableList()
        rvPokemons.apply {
            adapter = adapterList
            adapterList.onItemClickListener = {
               // startActivity(it?.let { pokemons -> PokemonDetailsActivity.getStartIntent(context, pokemons) })
            }
        }

        loader_pokemon.visibility = GONE
    }
}