package com.example.superheroes.data.dtos

import com.example.superheroes.data.PowerStats
import com.example.superheroes.data.SuperHero

// DTOs: espejo del JSON. Nulables porque la API trae nulls (p. ej. publisher).
data class SuperHeroDto(
    val id: Int,
    val name: String?,
    val powerstats: PowerStatsDto?,
    val appearance: AppearanceDto?,
    val biography: BiographyDto?,
    val work: WorkDto?,
    val images: ImagesDto?
)

data class PowerStatsDto(
    val intelligence: Int?,
    val strength: Int?,
    val speed: Int?,
    val durability: Int?,
    val power: Int?,
    val combat: Int?
)

data class AppearanceDto(
    val gender: String?,
    val race: String?
)

data class BiographyDto(
    val fullName: String?,
    val placeOfBirth: String?,
    val firstAppearance: String?,
    val publisher: String?
)

data class WorkDto(
    val occupation: String?
)

data class ImagesDto(
    val md: String?,
    val lg: String?
)

// La API usa null, "" o "-" cuando no tiene el dato
private fun String?.orDesconocido(): String =
    if (this.isNullOrBlank() || this == "-") "Desconocido" else this

// Mapper DTO -> modelo de dominio
fun SuperHeroDto.toSuperHero(): SuperHero {
    return SuperHero(
        id = id,
        name = name.orDesconocido(),
        fullName = biography?.fullName.orDesconocido(),
        publisher = biography?.publisher.orDesconocido(),
        imageUrl = images?.md.orEmpty(),
        imageUrlLarge = images?.lg.orEmpty(),
        powerStats = PowerStats(
            intelligence = powerstats?.intelligence ?: 0,
            strength = powerstats?.strength ?: 0,
            speed = powerstats?.speed ?: 0,
            durability = powerstats?.durability ?: 0,
            power = powerstats?.power ?: 0,
            combat = powerstats?.combat ?: 0
        ),
        gender = appearance?.gender.orDesconocido(),
        race = appearance?.race.orDesconocido(),
        placeOfBirth = biography?.placeOfBirth.orDesconocido(),
        firstAppearance = biography?.firstAppearance.orDesconocido(),
        occupation = work?.occupation.orDesconocido()
    )
}
