package com.tac.nba_companion.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.usecases.GetAllTeamsUseCase
import com.tac.nba_companion.presentation.common.IErrorTypeToErrorTextConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * HomeViewModel
 * @param getAllTeamsUseCase : cas d'usage pour la récupération des équipes NBA
 * @param errorTextConverterImpl : converter d'ErrorType en ErrorText pour la vue
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllTeamsUseCase: GetAllTeamsUseCase,
    private val errorTextConverterImpl: IErrorTypeToErrorTextConverter
) : ViewModel() {

    // MutableStateFlow() Permet d'observer des données qui changent pour mettre à jour l'interface
    private val _uiState = MutableStateFlow(HomeState())
    // Version readonly de MutableStateFlow qui sera affiché à la vue
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        getTeams()
    }

    private fun getTeams() {
        // Démarre une coroutine sans bloquer le thread courant
        viewModelScope.launch {
            getAllTeamsUseCase()
                // Collect des résultats
                .collect { teams ->
                    // Log.d("myDebug", teams.toString())
                    // Gestion des deux cas possibles (Success || Error)
                    when (teams) {
                        is Resource.Success -> {
                            _uiState.update { currentState ->
                                currentState.copy(teams = teams.data, isLoading = false)
                            }
                        }
                        is Resource.Error -> {
                            _uiState.update { currentState ->
                                currentState.copy(isError = true, errorText = errorTextConverterImpl.convert(teams.error), isLoading = false)
                            }
                        }
                    }
                }
        }
    }
}