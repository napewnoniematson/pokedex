package com.example.pokedex.viewmodel.api

class PokedexHelper(private val apiService: PokedexService) {

    suspend fun getNationalDex() = apiService.getNationalDex()
}