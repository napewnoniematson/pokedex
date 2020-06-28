package com.example.pokedex.model

class Pokemon (
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val forms: List<NamedApiResource>,
    val game_indices: List<VersionGameIndex>,
    val held_items: List<PokemonHeldItem>,
    val location_area_encounters: String,
    val moves: List<PokemonMove>,
    val sprites: PokemonSprites,
    val species: NamedApiResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>

)