package edu.rit.pokedexfinalproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.rit.pokedexfinalproject.models.Pokemon

class PokemonViewModel(private val utils: Utils): ViewModel() {
    private val mutablePokemon = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> get() = mutablePokemon

    fun fetchPokemon(context: Context) {
        val jsonString = utils.getJson(context, "pokemon.json")

        val gson = Gson()
        val listPokemonType = object: TypeToken<List<Pokemon>>() {}.type

        val pokemons = gson.fromJson<List<Pokemon>>(jsonString, listPokemonType)
        mutablePokemon.value = pokemons
    }
}