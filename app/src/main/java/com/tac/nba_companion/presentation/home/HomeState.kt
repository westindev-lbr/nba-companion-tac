package com.tac.nba_companion.presentation.home

import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.presentation.common.ErrorText

/**
 * HomeState
 * Différents états de la vue qui seront collectés
 * dans le HomeViewModel et injectés à la vue (HomeScreen)
 */
data class HomeState(
    val teams: List<Team> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val errorText: ErrorText? = null,
    val isGridView: Boolean = false
)
