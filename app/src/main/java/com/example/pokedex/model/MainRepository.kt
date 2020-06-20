package com.example.pokedex.model

import com.example.pokedex.viewmodel.api.PokedexHelper

class MainRepository(private val apiHelper: PokedexHelper) {

    suspend fun getNationalDex() = apiHelper.getNationalDex()
}