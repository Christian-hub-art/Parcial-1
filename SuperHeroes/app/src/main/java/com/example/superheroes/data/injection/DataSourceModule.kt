package com.example.superheroes.data.injection

import com.example.superheroes.data.datasource.SuperHeroRemoteDataSource
import com.example.superheroes.data.datasource.impl.SuperHeroRetrofitDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @Binds conecta la interfaz con su implementación:
// "cuando alguien pida SuperHeroRemoteDataSource, entrégale SuperHeroRetrofitDataSourceImpl".
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindSuperHeroRemoteDataSource(
        impl: SuperHeroRetrofitDataSourceImpl
    ): SuperHeroRemoteDataSource
}
