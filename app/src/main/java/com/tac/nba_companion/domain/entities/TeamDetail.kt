package com.tac.nba_companion.domain.entities

import androidx.compose.ui.graphics.Color

data class TeamDetail(
    val id: Int,
    val name: String,
    val abbreviation: String,
    val location: String,
    val logo: String,
    val color: Color,
    val altColor: Color,
    val currentRank: String,
    val venueName: String,
    val venueImg: String,
)
