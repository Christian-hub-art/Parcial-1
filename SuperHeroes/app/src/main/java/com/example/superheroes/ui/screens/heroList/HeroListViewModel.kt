package com.example.superheroes.ui.screens.heroList

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
class HeroListViewModel @Inject constructor(
    private val superHeroRepository: SuperHeroRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroListState())
    val uiState: StateFlow<HeroListState> = _uiState.asStateFlow()

    init {
        loadSuperHeroes()
    }

    fun loadSuperHeroes() {
        _uiState.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            superHeroRepository.getSuperHeroes()
                .onSuccess { superHeroes ->
                    _uiState.update { it.copy(superHeroes = superHeroes, isLoading = false) }
                }
                .onFailure { exception ->
                    _uiState.update { it.copy(isLoading = false, error = exception.message) }
                }
        }
    }
}
