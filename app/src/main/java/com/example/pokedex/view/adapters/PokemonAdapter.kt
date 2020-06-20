package com.example.pokedex.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.model.PokemonEntry
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(private val pokemons: ArrayList<PokemonEntry>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val cardView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false) as CardView
        return PokemonViewHolder(cardView)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemonEntry: PokemonEntry = pokemons[position]
        var pokemonIndexString = pokemonEntry.entry_number.toString()
        pokemonIndexString = pokemonIndexString.padStart(3, '0')
        val pokemonText = "#$pokemonIndexString ${pokemonEntry.pokemon_species.name.capitalize()}"
        holder.itemView.pokemonItemTextView.text = pokemonText

        holder.itemView.setOnClickListener {
            Toast
                .makeText(holder.itemView.context, "position: $position", Toast.LENGTH_LONG)
                .show()
        }
        val imageUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonEntry.entry_number}.png"

        Glide
            .with(holder.itemView.context)
            .load(imageUrl)
            .override(108,108)
            .fitCenter()
            .into(holder.itemView.pokemonItemImageView)
    }

    fun updatePokemons(pokemons: List<PokemonEntry>) {
        this.pokemons.apply {
            clear()
            addAll(pokemons)
        }
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}