package com.example.superheroes.ui.screens.heroList

import com.example.superheroes.data.SuperHero

// Todo lo que la pantalla necesita para dibujarse, en un solo objeto inmutable.
data class HeroListState(
    val superHeroes: List<SuperHero> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
