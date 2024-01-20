package com.tac.nba_companion.data.remote.dto.team

import com.tac.nba_companion.core.common.DomainMapper
import com.tac.nba_companion.domain.entities.Team

class TeamDtoMapper : DomainMapper<TeamDto, Team> {
    override fun mapToDomainEntity(model: TeamDto): Team {
        return Team(
            id = model.id,
            name = model.name,
            location = model.location,
            abbreviation = model.abbreviation,
            logo = model.logos.first().href,
        )
    }

    fun toDomainList(initial: List<TeamDto>): List<Team> {
        return initial.map { mapToDomainEntity(it) }
    }
}
