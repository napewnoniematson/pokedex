package com.example.pokedex.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.model.MainRepository
import com.example.pokedex.viewmodel.api.MainViewModel
import com.example.pokedex.viewmodel.api.PokedexHelper

class ViewModelFactory(private val apiHelper: PokedexHelper): ViewModelProvider.Factory {

    private val illegalArgumentExceptionMessage: String = "Unknown Argument Exception"

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException(illegalArgumentExceptionMessage)
    }
}