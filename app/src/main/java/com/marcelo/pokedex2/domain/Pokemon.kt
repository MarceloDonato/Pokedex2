package com.marcelo.pokedex2.domain


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemon (
    val number: Int,
    val name: String,
    val types: List<PokemonType>
        ) :Serializable
{

    val formattedName = name.capitalize()

    val formattedNumber = number.toString().padStart(3,'0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}
