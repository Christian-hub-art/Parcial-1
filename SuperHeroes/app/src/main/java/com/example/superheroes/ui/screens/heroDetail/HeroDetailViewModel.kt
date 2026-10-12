package com.example.superheroes.ui.screens.heroDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.data.repository.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val superHeroRepository: SuperHeroRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroDetailState())
    val uiState: StateFlow<HeroDetailState> = _uiState.asStateFlow()

    fun loadData(heroId: Int) {
        _uiState.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            superHeroRepository.getSuperHeroById(heroId)
                .onSuccess { superHero ->
                    _uiState.update { it.copy(superHero = superHero, isLoading = false) }
                }
                .onFailure { exception ->
                    _uiState.update { it.copy(isLoading = false, error = exception.message) }
                }
        }
    }
}
