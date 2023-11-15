package com.tac.nba_companion.domain.usecases

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow

class GetTeamListUseCase(private val teamRepository: ITeamRepository) {
    operator fun invoke(): Flow<Resource<List<Team>>> = teamRepository.teams();

}