package edu.rit.pokedexfinalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.rit.pokedexfinalproject.models.Pokemon

class PokemonViewModel(get: Any) : ViewModel() {
    private val mutablePokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> get() = mutablePokemons
}