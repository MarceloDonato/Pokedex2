package com.marcelo.pokedex2.domain


import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.math.RoundingMode
import java.text.DecimalFormat

data class Pokemon (
   // @SerializedName("height") val height: Int?,
    @SerializedName("number") val number: Int,
    @SerializedName("name")val name: String,
    @SerializedName("types") val types: List<PokemonType>

        ) :Serializable
{

  //  val formattedName = name.capitalize()

    val formattedNumber = number.toString().padStart(3,'0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}

fun convertValue(convert: Int?): String {
    convert?.let {
        return try {
            val value = ((it.toDouble()) / 10)
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.CEILING
            df.format(value).replace(",", ".").toDouble().toString()
        } catch (e: Exception) {
            "0"
        }
    } ?: run {
        return "0"
    }
}
