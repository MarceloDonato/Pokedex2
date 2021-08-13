package com.marcelo.pokedex2.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonType (
    @SerializedName ("name")val name: String,
        ): Serializable