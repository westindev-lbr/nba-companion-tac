package com.tac.nba_companion.data.remote.response

import com.google.gson.annotations.SerializedName
import com.tac.nba_companion.data.remote.dto.team.TeamDto

data class SportsData(
    // @SerializedName : l'annotation permet d'assurer la correspondance de l'objet JSON
    // et de le mapper correctement à la variable
    @SerializedName("sports")
    val sports: List<Sport>
)

data class Sport(
    @SerializedName("leagues")
    val leagues: List<League>
)

data class League(
    @SerializedName("teams")
    val teams: List<TeamElement>
)

data class TeamElement(
    @SerializedName("team")
    val team: TeamDto
)
