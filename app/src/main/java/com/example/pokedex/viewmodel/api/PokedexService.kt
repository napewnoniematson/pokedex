package com.example.pokedex.viewmodel.api

import com.example.pokedex.model.Pokedex
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonSpecies
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexService {

    @GET("pokedex/1")
    suspend fun getNationalDex(): Pokedex

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpeciesById(@Path("id") id: Int): PokemonSpecies
}