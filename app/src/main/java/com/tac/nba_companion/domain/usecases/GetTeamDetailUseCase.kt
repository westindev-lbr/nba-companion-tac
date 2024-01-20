package com.tac.nba_companion.domain.usecases

import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.TeamDetail
import com.tac.nba_companion.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamDetailUseCase @Inject constructor(private val repository: ITeamRepository) {
    operator fun invoke(teamId: Int): Flow<Resource<TeamDetail>> {
        return repository.getTeamDetail(id = teamId)
    }
}
