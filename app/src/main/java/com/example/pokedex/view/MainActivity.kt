package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import com.example.pokedex.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
//        pokemonRecyclerView.adapter = PokemonRVAdapter()
    }
}