package edu.rit.pokedexfinalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.rit.pokedexfinalproject.models.Pokemon
import edu.rit.pokedexfinalproject.utils.toDrawable

class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var image: ImageView = view.findViewById(R.id.pokemonImg)
    var name: TextView = view.findViewById(R.id.tvName)
    var description: TextView = view.findViewById(R.id.tvType)
}

class PokemonRecyclerViewAdapter(private var pokemons: List<Pokemon>): RecyclerView.Adapter<PokemonViewHolder>() {

    fun loadData(newPokemons: List<Pokemon>) {
        pokemons = newPokemons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]

        holder.image.setImageResource(pokemon.img.toDrawable(holder.image.context))
        holder.name.text = pokemon.name
        holder.description.text = pokemon.description
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}