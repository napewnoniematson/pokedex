package com.example.pokedex.viewmodel.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.pokedex.model.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository): ViewModel(){

    fun getNationalDex() = liveData(Dispatchers.IO) {
        emit(mainRepository.getNationalDex())
    }
}