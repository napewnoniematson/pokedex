package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.viewmodel.api.MainViewModel
import com.example.pokedex.viewmodel.api.PokedexHelper
import com.example.pokedex.viewmodel.api.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.pokemon_stats.*

class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val pokemonIndex = bundle.getInt("POKEMON_DETAILS_ENTRY_NUMBER", 0)
            if (pokemonIndex == 0)
                return
            val imageUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonIndex}.png"

            Glide
                .with(this)
                .load(imageUrl)
                .override(108, 108)
                .fitCenter()
                .into(pokemonDetailsImageView)

            viewModel = ViewModelProvider(
                this,
                ViewModelFactory(PokedexHelper(RetrofitBuilder.pokedexService))
            ).get(MainViewModel::class.java)

            viewModel.getPokemonById(pokemonIndex).observe(this, Observer {
                it?.let {
                    val statDict: MutableMap<String, Int> = mutableMapOf()
                    it.stats.forEach { s ->
                        val key = s.stat.name
                        val value = s.base_stat
                        statDict[key] = value
                    }
                    hpValTextView.text =
                        if (statDict.containsKey("hp")) statDict["hp"].toString() else getString(R.string.pokemon_stats_default_value)
                    atkValTextView.text = statDict["attack"].toString()
                }
            })

            viewModel.getPokemonSpeciesById(pokemonIndex).observe(this, Observer {
                it?.let {
                    val engDesc = it.flavor_text_entries.filter {
                        flavorText -> flavorText.language.name == "en"
                    }
                    pokemonDetailsDescriptionEditText.setText(engDesc[0].flavor_text.trim())
                }
            })

        }

    }
}