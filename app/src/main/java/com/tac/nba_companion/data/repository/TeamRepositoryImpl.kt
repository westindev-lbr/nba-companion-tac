package com.tac.nba_companion.data.repository

import android.util.Log
import com.tac.nba_companion.core.common.ErrorType
import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.core.common.extensions.toErrorType
import com.tac.nba_companion.data.datasource.ITeamDataSource
import com.tac.nba_companion.data.datasource.TeamRemoteDataSource
import com.tac.nba_companion.data.network.dto.TeamDtoMapper
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.entities.TeamDetail
import com.tac.nba_companion.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class TeamRepositoryImpl(
    private val dataSource: ITeamDataSource = TeamRemoteDataSource(),
    private val teamDtoMapper: TeamDtoMapper

) : ITeamRepository {

    override fun getTeams(): Flow<Resource<List<Team>>> = flow<Resource<List<Team>>> {

        Log.d("myTag", "datasource")
        val teamsDto = dataSource.getTeams().first()
        //var jsonTeamdto = Json.encodeToString(teamsDto)
        Log.d("myTag", "teamsDto: $teamsDto")
        if (teamsDto != null) {
            val teams = teamsDto.map { teamDtoMapper.mapToDomainEntity( it ) }
            emit(Resource.Success(teams))
        }else {
            emit(Resource.Error(ErrorType.Unknown))
        }

    }.catch { exception ->
        val errorType = exception.toErrorType()
        Log.e("myTag", "Error fetching teams: $errorType")
        emit(Resource.Error(errorType))
    }

    override fun getTeamDetails(teamId: Int): Flow<Resource<TeamDetail>> {
        TODO("Not yet implemented")
    }


}
