package com.example.superheroes.data

// Modelo de dominio: solo lo que la UI necesita, sin nulos.
data class SuperHero(
    val id: Int,
    val name: String,
    val fullName: String,
    val publisher: String,
    val imageUrl: String,
    val imageUrlLarge: String,
    val powerStats: PowerStats,
    val gender: String,
    val race: String,
    val placeOfBirth: String,
    val firstAppearance: String,
    val occupation: String
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)
