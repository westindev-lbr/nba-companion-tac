package com.tac.nba_companion.domain.entities

data class Team(
    val id: Int,
    val name: String,
    val abbreviation: String,
    val location: String,
    val logo: String,
)
