package com.example.superheroes.data.datasource.impl

import com.example.superheroes.data.datasource.SuperHeroRemoteDataSource
import com.example.superheroes.data.datasource.services.SuperHeroRetrofitService
import com.example.superheroes.data.dtos.SuperHeroDto
import javax.inject.Inject

// Implementación con Retrofit. Hilt la inyecta donde se pida SuperHeroRemoteDataSource.
class SuperHeroRetrofitDataSourceImpl @Inject constructor(
    private val service: SuperHeroRetrofitService
) : SuperHeroRemoteDataSource {

    override suspend fun getAllSuperHeroes(): List<SuperHeroDto> {
        return service.getAllSuperHeroes()
    }

    override suspend fun getSuperHeroById(id: Int): SuperHeroDto {
        return service.getSuperHeroById(id)
    }
}
