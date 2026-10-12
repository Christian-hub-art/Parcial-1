package com.example.superheroes.data.datasource

import com.example.superheroes.data.dtos.SuperHeroDto

// Abstracción de la fuente remota: el repositorio depende de esta interfaz, no de Retrofit.
interface SuperHeroRemoteDataSource {
    suspend fun getAllSuperHeroes(): List<SuperHeroDto>
    suspend fun getSuperHeroById(id: Int): SuperHeroDto
}
