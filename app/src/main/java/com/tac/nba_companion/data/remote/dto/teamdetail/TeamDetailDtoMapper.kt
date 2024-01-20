package com.tac.nba_companion.data.remote.dto.teamdetail

import androidx.compose.ui.graphics.Color
import com.tac.nba_companion.core.common.DomainMapper
import com.tac.nba_companion.domain.entities.TeamDetail

class TeamDetailDtoMapper : DomainMapper<TeamDetailDTO, TeamDetail> {


    override fun mapToDomainEntity(model: TeamDetailDTO): TeamDetail {
        return TeamDetail(
            id = model.id,
            name = model.name,
            abbreviation = model.abbreviation,
            location = model.location,
            logo = model.logos.first().href,
            color = Color(color = android.graphics.Color.parseColor("#${model.color}")),
            altColor = Color(color = android.graphics.Color.parseColor("#${model.altColor}")),
            currentRank = model.currentRank,
            venueName = model.franchise.venue.fullName,
            venueImg = model.franchise.venue.images.first().href
            )
    }
}