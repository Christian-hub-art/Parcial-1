package com.example.superheroes.ui.screens.heroDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.superheroes.data.SuperHero

@Composable
fun HeroDetailScreen(
    heroId: Int,
    heroDetailViewModel: HeroDetailViewModel,
    modifier: Modifier = Modifier
) {
    val state by heroDetailViewModel.uiState.collectAsState()

    // Pide el héroe a la API al entrar a la pantalla
    LaunchedEffect(heroId) {
        heroDetailViewModel.loadData(heroId)
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        state.superHero?.let { superHero ->
            BodyHeroDetailScreen(superHero = superHero)
        }
    }
}


@Composable
fun BodyHeroDetailScreen(
    superHero: SuperHero,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        AsyncImage(
            model = superHero.imageUrlLarge,
            contentDescription = superHero.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = superHero.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(text = superHero.fullName, style = MaterialTheme.typography.titleMedium)
        Text(text = superHero.publisher, color = MaterialTheme.colorScheme.primary)

        Spacer(modifier = Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Estadísticas", fontWeight = FontWeight.Bold)
                FilaDato("Inteligencia", "${superHero.powerStats.intelligence}")
                FilaDato("Fuerza", "${superHero.powerStats.strength}")
                FilaDato("Velocidad", "${superHero.powerStats.speed}")
                FilaDato("Durabilidad", "${superHero.powerStats.durability}")
                FilaDato("Poder", "${superHero.powerStats.power}")
                FilaDato("Combate", "${superHero.powerStats.combat}")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Información", fontWeight = FontWeight.Bold)
                FilaDato("Género", superHero.gender)
                FilaDato("Raza", superHero.race)
                FilaDato("Nacimiento", superHero.placeOfBirth)
                FilaDato("Primera aparición", superHero.firstAppearance)
                FilaDato("Ocupación", superHero.occupation)
            }
        }
    }
}

// Fila etiqueta : valor, usada dentro de las dos Cards
@Composable
private fun FilaDato(etiqueta: String, valor: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        Text(text = etiqueta, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = valor, textAlign = TextAlign.End, modifier = Modifier.weight(1f))
    }
}
