package com.tac.nba_companion.domain.repository

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.entities.TeamDetail
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {
    /**
     * Resource : pour gérer deux cas possibles (succès || echec) afin d'envoyer à la vue selon le cas.
     * Flow : Permet de gérer des flux de données asynchrones.
     */
    fun getTeamsCollection(): Flow<Resource<List<Team>>>
    fun getTeamDetail(id: Int): Flow<Resource<TeamDetail>>
}