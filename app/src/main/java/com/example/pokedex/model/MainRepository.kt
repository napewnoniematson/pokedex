package com.example.pokedex.model

import com.example.pokedex.viewmodel.api.PokedexHelper
import retrofit2.http.Path

class MainRepository(private val apiHelper: PokedexHelper) {

    suspend fun getNationalDex() = apiHelper.getNationalDex()

    suspend fun getPokemonById(id: Int) = apiHelper.getPokemonById(id)

    suspend fun getPokemonSpeciesById(id: Int) = apiHelper.getPokemonSpeciesById(id)
}