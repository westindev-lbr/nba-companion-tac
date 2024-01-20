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
                // Le type Response de Retrofit permet d'encapsuler une réponse HTTP
                if (response.isSuccessful) {
                    // Chaînage de data pour cibler les TeamElement et
                    // les transformer en TeamDto à l'aide de map
                    val teamListDto =
                        response.body()!!.sports[0].leagues[0].teams.map { t -> t.team }
                    // teamListDto.map {   Log.d("myDebugApiData", it.toString())}
                    // Mapper le Dto en Entité du domaine
                    val teams = teamDtoMapper.toDomainList(teamListDto)
                    //Log.d("myDebugTeams", teams.toString())
                    // Emettre la réponse
                    emit(Resource.Success(teams))
                } else {
                    // Gérer les cas d'érreurs
                    TODO("Not yet implemented")
                }
            } catch (e: Exception) {
                // Gstion exception
                TODO("Not yet implemented")
            }
        }
    }
}
