package com.example.pokedex.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val cardView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false) as CardView
        return PokemonViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemonNumberNameText = "#00$position pokemon_$position"
        holder.itemView.pokemonItemTextView.text = pokemonNumberNameText
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "position: $position", Toast.LENGTH_LONG)
                .show()
        }
//        holder.itemView.pokemonItemImageView
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}