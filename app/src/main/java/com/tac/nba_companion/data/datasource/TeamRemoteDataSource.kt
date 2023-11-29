package com.tac.nba_companion.data.datasource

import android.util.Log
import com.tac.nba_companion.data.network.NbaTeamsApi
import com.tac.nba_companion.data.network.dto.TeamDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface ITeamDataSource {
    suspend fun getTeams(): Flow<List<TeamDto>>
}

class TeamRemoteDataSource : ITeamDataSource {
    private val nbaTeamsApi: NbaTeamsApi by lazy {
        NbaTeamsApi.getInstance()
    }

    override suspend fun getTeams(): Flow<List<TeamDto>> {
        return flow {
            try {
                emit(nbaTeamsApi.getTeamsData().sports[0].leagues[0].teams.map { t -> t.team  }
                )
            } catch (e: Exception) {
                // Gérer les erreurs réseau ici
                Log.d("myTag",e.message.toString())
                throw e
            }
        }
    }
}