package com.example.superheroes.data.datasource.services

import com.example.superheroes.data.dtos.SuperHeroDto
import retrofit2.http.GET
import retrofit2.http.Path

// Contrato HTTP. Retrofit genera la implementación en tiempo de ejecución.
// Base URL: https://akabab.github.io/superhero-api/api/
interface SuperHeroRetrofitService {

    @GET("all.json")
    suspend fun getAllSuperHeroes(): List<SuperHeroDto>

    @GET("id/{id}.json")
    suspend fun getSuperHeroById(@Path("id") id: Int): SuperHeroDto
}
