package com.tac.nba_companion.domain.repository

import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.entities.TeamDetail

interface ITeamRepository {
    fun teams(): List<Team>
    fun teamDetails(teamId: Int): TeamDetail
}

