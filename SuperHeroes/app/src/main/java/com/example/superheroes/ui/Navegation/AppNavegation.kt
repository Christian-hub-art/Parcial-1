package com.example.superheroes.ui.Navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.superheroes.ui.screens.heroDetail.HeroDetailScreen
import com.example.superheroes.ui.screens.heroDetail.HeroDetailViewModel
import com.example.superheroes.ui.screens.heroList.HeroListScreen
import com.example.superheroes.ui.screens.heroList.HeroListViewModel

// Rutas centralizadas
sealed class Screens(val route: String) {
    object HeroList : Screens("heroList")

    object HeroDetail : Screens("heroDetail/{heroId}") {
        fun createRoute(heroId: Int) = "heroDetail/$heroId"
    }
}

@Composable
fun AppNavegation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HeroList.route,
        modifier = modifier
    ) {
        composable(route = Screens.HeroList.route) {
            val viewModel: HeroListViewModel = hiltViewModel()
            HeroListScreen(
                heroListViewModel = viewModel,
                onHeroClick = { heroId ->
                    navController.navigate(Screens.HeroDetail.createRoute(heroId))
                }
            )
        }

        composable(
            route = Screens.HeroDetail.route,
            arguments = listOf(navArgument("heroId") { type = NavType.IntType })
        ) {
            val heroId = it.arguments?.getInt("heroId") ?: 0
            val viewModel: HeroDetailViewModel = hiltViewModel()
            HeroDetailScreen(
                heroId = heroId,
                heroDetailViewModel = viewModel
            )
        }
    }
}
