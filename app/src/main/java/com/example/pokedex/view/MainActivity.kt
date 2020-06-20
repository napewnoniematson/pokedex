package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.pokedex.R
import com.example.pokedex.view.adapters.PokemonAdapter
import com.example.pokedex.viewmodel.api.MainViewModel
import com.example.pokedex.viewmodel.api.PokedexHelper
import com.example.pokedex.viewmodel.api.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(PokedexHelper(RetrofitBuilder.pokedexService))
        ).get(MainViewModel::class.java)


        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PokemonAdapter(arrayListOf())
        pokemonRecyclerView.adapter = adapter


        viewModel.getNationalDex().observe(this, Observer {
            it?.let {
                adapter.apply {
                    updatePokemons(it.pokemon_entries)
                    notifyDataSetChanged()
                }
            }
        })

    }
}