package com.tac.nba_companion.data.network.dto

import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.util.DomainMapper

class TeamDtoMapper: DomainMapper<TeamDto, Team> {
    override fun mapToDomainEntity(model: TeamDto): Team {
        return Team(
            id = model.id,
            name = model.name,
            logo = model.logo.first().href,
        )
    }

    // Pas vraiment utile car aucune méthode post mais on pourrait imaginer en avoir dans notre api
    //override fun mapFromDomainEntity(entityDomain: Team): TeamDto {
    //    return TeamDto(
    //        id = entityDomain.id,
    //        name = entityDomain.name,
    //        logo =
    //    )
    // }
}