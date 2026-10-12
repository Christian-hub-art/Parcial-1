package com.example.superheroes.ui.screens.heroDetail

import com.example.superheroes.data.SuperHero

data class HeroDetailState(
    val superHero: SuperHero? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
