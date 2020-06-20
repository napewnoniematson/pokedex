package com.example.pokedex.model

data class Pokedex(
    val id: Int,
    val name: String,
    val is_main_series: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    val pokemon_entries: List<PokemonEntry>,
    val region: NamedApiResource,
    val version_groups: List<NamedApiResource>
)