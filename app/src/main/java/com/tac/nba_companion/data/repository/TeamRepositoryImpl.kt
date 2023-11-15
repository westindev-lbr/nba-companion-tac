package com.tac.nba_companion.data.repository

import com.tac.nba_companion.data.datasource.ITeamRemoteDataSource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.entities.TeamDetail
import com.tac.nba_companion.domain.repository.ITeamRepository

class TeamRepositoryImpl(
    private val teamRemoteDataSource: ITeamRemoteDataSource

) : ITeamRepository{

    override fun teams(): List<Team> {
        TODO("Not yet implemented")
    }

    override fun teamDetails(teamId: Int): TeamDetail {
        TODO("Not yet implemented")
    }

}