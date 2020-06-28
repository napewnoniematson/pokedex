package com.example.pokedex.model

class PokemonSpecies(
    val id: Int,
    val name: String,
    val order: Int,
    val gender_rate: Int,
    val capture_rate: Int,
    val base_happiness: Int,
    val is_baby: Boolean,
    val hatch_counter: Int,
    val has_gender_differences: Boolean,
    val forms_switchable: Boolean,
    val growth_rate: NamedApiResource,
    val pokedex_numbers: List<PokemonSpeciesDexEntry>,
    val egg_groups: List<NamedApiResource>,
    val color: NamedApiResource,
    val shape: NamedApiResource,
    val evolves_from_species: NamedApiResource,
    val evolution_chain: ApiResource,
    val habitat: NamedApiResource,
    val generation: NamedApiResource,
    val names: List<Name>,
    val pal_park_encounters: List<PalParkEncounterArea>,
    val flavor_text_entries: List<FlavorText>,
    val form_descriptions: List<Description>,
    val genera: List<Genus>,
    val varieties: List<PokemonSpeciesVariety>
)
