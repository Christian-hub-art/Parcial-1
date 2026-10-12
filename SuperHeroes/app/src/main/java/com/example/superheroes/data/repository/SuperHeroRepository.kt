package com.example.superheroes.data.repository

import com.example.superheroes.data.SuperHero
import com.example.superheroes.data.datasource.SuperHeroRemoteDataSource
import com.example.superheroes.data.dtos.toSuperHero
import javax.inject.Inject

// Única puerta a los datos: mapea DTO -> SuperHero y envuelve en Result.
class SuperHeroRepository @Inject constructor(
    private val superHeroRemoteDataSource: SuperHeroRemoteDataSource
) {
    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        return try {
            val superHeroes = superHeroRemoteDataSource.getAllSuperHeroes()
            Result.success(superHeroes.map { it.toSuperHero() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getSuperHeroById(id: Int): Result<SuperHero> {
        return try {
            val superHero = superHeroRemoteDataSource.getSuperHeroById(id)
            Result.success(superHero.toSuperHero())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
