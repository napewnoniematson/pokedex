package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pokedex.R
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        Toast.makeText(this, "Haj", Toast.LENGTH_LONG).show()
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
//            val pokemonIndex = bundle.getInt("POKEMON_DETAILS_ENTRY_NUMBER", 0)
            val pokemonIndex = 1
            val imageUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonIndex}.png"

            Glide
                .with(this)
                .load(imageUrl)
                .override(108,108)
                .fitCenter()
                .into(pokemonDetailsImageView)
        }

    }
}