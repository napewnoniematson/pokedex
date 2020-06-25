package com.example.pokedex.model

class PokemonMove(
    val move: NamedApiResource,
    val version_group_details: List<PokemonMoveVersion>
)