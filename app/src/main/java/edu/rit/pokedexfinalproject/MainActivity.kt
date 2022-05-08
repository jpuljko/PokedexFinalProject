package edu.rit.pokedexfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.rit.pokedexfinalproject.models.Pokemon
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val viewModel: PokemonViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeFromViewModal()
        viewModel.fetchPokemon(this)
    }

    private fun observeFromViewModal() {
        viewModel.pokemons.observe(this) { pokemons ->
            Log.d(TAG, "The count of the pokemons: ${pokemons.count()}")
        }
    }
}