package com.tac.nba_companion.data.repository

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.data.remote.EspnNbaApi
import com.tac.nba_companion.data.remote.dto.team.TeamDtoMapper
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Implémentation de TeamRepository
 * Injection de dépendance
 * @param api -> EspnNbaApi : Gestion des appels à l'api
 * @param teamDtoMapper -> Mapper de Dto vers Entity
 */
class TeamRepositoryImpl @Inject constructor(
    private val api: EspnNbaApi,
    private val teamDtoMapper: TeamDtoMapper
) : ITeamRepository {

    override fun getTeamsCollection(): Flow<Resource<List<Team>>> {
        // Flow pour collecter les données de façon asynchrone
        return flow {
            try {

                val response = api.fetchTeamsData()
                TODO("Not yet implemented")
                // Analyser les données pour cibler les bonnes données à récupérer pour le DTO
                // Mapper le Dto en Entité du domaine
                // Emettre la réponse
                // Gérer les cas d'érreurs

            } catch (e: Exception) {
                // Gstion exception
            }
        }
    }
}
