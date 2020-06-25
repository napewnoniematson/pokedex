package com.example.pokedex.viewmodel.api

import com.example.pokedex.model.PokemonSpecies
import retrofit2.http.Path

class PokedexHelper(private val apiService: PokedexService) {

    suspend fun getNationalDex() = apiService.getNationalDex()

    suspend fun getPokemonById(id: Int) = apiService.getPokemonById(id)

    suspend fun getPokemonSpeciesById(id: Int) = apiService.getPokemonSpeciesById(id)
}