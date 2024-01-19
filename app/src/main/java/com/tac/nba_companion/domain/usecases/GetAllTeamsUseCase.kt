package com.tac.nba_companion.domain.usecases

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Récupère les équipes NBA via le repository
 * Retourne un Flow<Resource<List<Team>>>
 */
class GetAllTeamsUseCase @Inject constructor(private val repository: ITeamRepository) {
    /**
     * L'utilisation de operator fun invoke() en Kotlin est un moyen puissant de rendre les objets
     * de votre application plus flexibles et expressifs en leur permettant de se comporter comme
     * des fonctions.
     * Cette capacité est particulièrement utile dans les patterns de conception avancés et peut
     * rendre votre code plus intuitif et élégant.
     */
    operator fun invoke(): Flow<Resource<List<Team>>> {
        return repository.fetchTeams()
    }
}