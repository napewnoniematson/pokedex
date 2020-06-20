package com.example.pokedex.viewmodel.api

import com.example.pokedex.model.Pokedex
import retrofit2.http.GET

interface PokedexService {

    @GET("pokedex/1")
    suspend fun getNationalDex(): Pokedex
}