package com.tac.nba_companion.presentation.home

import androidx.lifecycle.ViewModel
import com.tac.nba_companion.domain.entities.Team

class HomeViewModel: ViewModel() {
    val team1 : Team = Team(1, "Dallas Mavericks")
    val team2 : Team = Team(2, "San Antonio")
    val team3 : Team = Team(1, "Dallas Mavericks")
    val team4 : Team = Team(2, "San Antonio")
    val team5 : Team = Team(1, "Dallas Mavericks")
    val team6 : Team = Team(2, "San Antonio")
    val teamsList: List<Team> = listOf(team1, team2, team3, team4, team5, team6)
}