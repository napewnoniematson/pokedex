package com.example.pokedex.view.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.model.PokemonEntry
import com.example.pokedex.view.PokemonDetailsActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.pokemon_grid_item.view.*
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(
    private val pokemons: ArrayList<PokemonEntry>,
    private val layoutManager: GridLayoutManager? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        LIST,
        GRID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ViewType.LIST.ordinal -> PokemonViewHolder(parent)
            else -> PokemonGridViewHolder(parent)
        }
    }

    override fun getItemCount(): Int = pokemons.size

    override fun getItemViewType(position: Int): Int {
        return if (layoutManager?.spanCount == 1) ViewType.LIST.ordinal
        else ViewType.GRID.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pokemonEntry: PokemonEntry = pokemons[position]
        if (getItemViewType(position) == ViewType.LIST.ordinal) {
            var pokemonIndexString = pokemonEntry.entry_number.toString()
            pokemonIndexString = pokemonIndexString.padStart(3, '0')
            val pokemonText =
                "#$pokemonIndexString ${pokemonEntry.pokemon_species.name.capitalize()}"
            holder.itemView.pokemonItemTextView.text = pokemonText

            holder.itemView.setOnClickListener {
                val activity = holder.itemView.context as Activity
                val intent: Intent = Intent(activity, PokemonDetailsActivity::class.java)
                val pokemonIndex: Int = pokemonEntry.entry_number
                intent.putExtra("POKEMON_DETAILS_ENTRY_NUMBER", pokemonIndex)
                holder.itemView.context.startActivity(intent)
            }
            val imageUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonEntry.entry_number}.png"

            Glide
                .with(holder.itemView.context)
                .load(imageUrl)
//                .override(108, 108)
//                .fitCenter()
                .into(holder.itemView.pokemonItemImageView)
        } else {
            holder.itemView.setOnClickListener {
                val activity = holder.itemView.context as Activity
                val intent: Intent = Intent(activity, PokemonDetailsActivity::class.java)
                val pokemonIndex: Int = pokemonEntry.entry_number
                intent.putExtra("POKEMON_DETAILS_ENTRY_NUMBER", pokemonIndex)
                holder.itemView.context.startActivity(intent)
            }
            val imageUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonEntry.entry_number}.png"
            Glide
                .with(holder.itemView.context)
                .load(imageUrl)
                .override(108, 108)
                .fitCenter()
                .into(holder.itemView.pokemonGridItemImageView)
        }
    }

    fun updatePokemons(pokemons: List<PokemonEntry>) {
        this.pokemons.apply {
            clear()
            addAll(pokemons)
        }
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) :
                this(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.pokemon_item, parent, false)
                )
    }

    class PokemonGridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        constructor(parent: ViewGroup) :
                this(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.pokemon_grid_item, parent, false)
                )
    }
}