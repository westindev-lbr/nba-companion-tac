package com.tac.nba_companion.data.datasource

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import kotlinx.coroutines.flow.Flow


interface ITeamRemoteDataSource {
    fun fetchTeams(): Flow<Resource<List<Team>>>
}

class TeamRemoteDataSource : ITeamRemoteDataSource {
    override fun fetchTeams(): Flow<Resource<List<Team>>> {
        TODO("Not yet implemented")
    }
}