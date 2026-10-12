package com.example.superheroes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.superheroes.ui.Navegation.AppNavegation

// Raíz de la UI: Scaffold + grafo de navegación
@Composable
fun SuperHeroesApp() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        AppNavegation(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
