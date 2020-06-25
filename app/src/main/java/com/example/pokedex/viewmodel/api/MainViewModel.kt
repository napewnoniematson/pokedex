package com.example.pokedex.viewmodel.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.pokedex.model.MainRepository
import com.example.pokedex.model.PokemonSpecies
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Path

class MainViewModel(private val mainRepository: MainRepository): ViewModel(){

    fun getNationalDex() = liveData(Dispatchers.IO) {
        emit(mainRepository.getNationalDex())
    }

    fun getPokemonById(id: Int) = liveData(Dispatchers.IO) {
        emit(mainRepository.getPokemonById(id))
    }

    fun getPokemonSpeciesById(id: Int) = liveData(Dispatchers.IO) {
        emit(mainRepository.getPokemonSpeciesById(id))
    }
}