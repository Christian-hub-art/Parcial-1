package com.example.superheroes.data.injection

import com.example.superheroes.data.datasource.services.SuperHeroRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Le enseña a Hilt cómo construir Retrofit y el servicio (una sola instancia).
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://akabab.github.io/superhero-api/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesSuperHeroRetrofitService(retrofit: Retrofit): SuperHeroRetrofitService {
        return retrofit.create(SuperHeroRetrofitService::class.java)
    }
}
