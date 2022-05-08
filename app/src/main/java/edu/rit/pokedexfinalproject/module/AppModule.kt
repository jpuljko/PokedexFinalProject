package edu.rit.pokedexfinalproject.module

import edu.rit.pokedexfinalproject.PokemonViewModel
import edu.rit.pokedexfinalproject.Utils
import org.koin.dsl.module

var appModule = module {
    single { Utils() }
    factory { PokemonViewModel(get()) }
}