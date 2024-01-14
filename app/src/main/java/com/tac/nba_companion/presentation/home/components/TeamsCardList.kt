package com.tac.nba_companion.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.domain.entities.Team

@Composable
fun TeamsCardList(
    modifier: Modifier = Modifier,
    teams: List<Team>,
) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        ) {
        items(
            count = teams.size
        ) {
            teams[it]?.let { team ->
                CardElevation(team = team)
            }
        }
    }
}

val team1 : Team = Team(1, "Dallas Mavericks")
val team2 : Team = Team(2, "San Antonio")
val teamsList: List<Team> = listOf(team1, team2)

@Preview
@Composable
fun TeamsCardListPreview(
) {
    TeamsCardList(teams = teamsList )
}