# SuperHeroes – Parcial 1 Desarrollo Móvil

App nativa Android (Kotlin + Jetpack Compose) que consume la [Superhero API](https://akabab.github.io/superhero-api/).

- **Pantalla inicial:** lista (`LazyColumn`) de todos los héroes en tarjetas con name, fullName, publisher e imagen.
- **Pantalla de detalle:** imagen grande, estadísticas, biografía, apariencia, trabajo y conexiones (endpoint `id/{id}.json`).

## Stack
MVVM · Repository · Hilt · Retrofit + Gson · Coil · Navigation Compose · StateFlow

## Estructura
```
com.example.superheroes
├── BaseApplication.kt            @HiltAndroidApp
├── MainActivity.kt               @AndroidEntryPoint
├── SuperHeroesApp.kt             Scaffold + TopAppBar + navegación
├── data
│   ├── SuperHero.kt              modelo de dominio
│   ├── dtos/SuperHeroDto.kt      DTOs del JSON + mapper toSuperHero()
│   ├── datasource
│   │   ├── SuperHeroRemoteDataSource.kt
│   │   ├── impl/SuperHeroRetrofitDataSourceImpl.kt
│   │   └── services/SuperHeroRetrofitService.kt
│   ├── repository/SuperHeroRepository.kt
│   └── injection/{AppModule, DataSourceModule}.kt
└── ui
    ├── Navegation/AppNavegation.kt
    ├── screens
    │   ├── heroList/{Screen, State, ViewModel, components/TarjetaHeroe}
    │   └── heroDetail/{Screen, State, ViewModel}
    └── theme/Theme.kt
```

## Ejecutar
Abrir la carpeta en Android Studio, sincronizar Gradle y correr en un emulador con Internet.
