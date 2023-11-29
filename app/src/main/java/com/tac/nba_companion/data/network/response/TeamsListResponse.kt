package com.tac.nba_companion.data.network.response

import com.google.gson.annotations.SerializedName
import com.tac.nba_companion.data.network.dto.TeamDto

data class SportsData(

    @SerializedName("sports")
    val sports: List<Sport>
)

data class Sport (
    @SerializedName("leagues")
    val leagues: List<League>
)

data class League (
    @SerializedName("teams")
    val teams: List<TeamElement>
)

data class TeamElement (
    @SerializedName("team")
    val team: TeamDto
)

data class TeamsListResponse (
    @SerializedName("sports")
    val teams: List<TeamDto>
)


