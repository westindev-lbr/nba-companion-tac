package com.tac.nba_companion.domain.repository

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.entities.TeamDetail
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {
    fun getTeams(): Flow<Resource<List<Team>>>
    fun getTeamDetails(teamId: Int): Flow<Resource<TeamDetail>>
}

