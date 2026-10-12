package com.example.superheroes.ui.screens.heroList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.SuperHero
import com.example.superheroes.ui.screens.heroList.components.TarjetaHeroe

@Composable
fun HeroListScreen(
    heroListViewModel: HeroListViewModel,
    onHeroClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by heroListViewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
       BodyHeroListScreen(
                superHeroes = state.superHeroes,
                onHeroClick = onHeroClick
            )
        }
    }


@Composable
fun BodyHeroListScreen(
    superHeroes: List<SuperHero>,
    onHeroClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(superHeroes, key = { it.id }) { superHero ->
            TarjetaHeroe(
                name = superHero.name,
                fullName = superHero.fullName,
                publisher = superHero.publisher,
                imageUrl = superHero.imageUrl,
                onClick = { onHeroClick(superHero.id) }
            )
        }
    }
}
