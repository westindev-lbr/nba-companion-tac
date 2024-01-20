package com.tac.nba_companion.domain.entities

data class TeamDetail(
    val id: Int,
    val name: String,
    val abbreviation: String,
    val location: String,
    val logo: String,
    val color: String,
    val altColor: String,
    val currentRank: String,
    val venueName: String,
    val venueImg: String,
)
