package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
            R.id.about_info_menu_bar_button -> {
                val infoDialog = AlertDialog.Builder(this).create()
                infoDialog.apply {
                    title = "About"
                    setMessage("It is pokedex project with list of pokemon and their details. It is Mateusz Cypel educational project")
                    setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, _ ->
                        dialog.dismiss()
                        title = getString(R.string.app_name)
                    }
                    show()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}