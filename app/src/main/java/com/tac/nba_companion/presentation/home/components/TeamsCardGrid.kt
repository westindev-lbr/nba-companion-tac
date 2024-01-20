package com.tac.nba_companion.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tac.nba_companion.domain.entities.Team

@Composable
fun TeamsCardGrid(
    teams: List<Team>,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(200.dp)
    ) {
        items(
            count = teams.size
        ) {
            CardGridElevation(team = teams[it])
        }
    }
}


@Preview
@Composable
fun TeamsCardGridPreview(
) {
    val team1 = Team(6, "Dallas Mavericks", location = "Dallas", abbreviation = "DAL", logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png" )
    val team2 = Team(5, "Cleveland Cavaliers", location = "Cleveland", abbreviation = "CLE", logo = "https://a.espncdn.com/i/teamlogos/nba/500/cle.png" )
    val teamsList: List<Team> = listOf(team1, team2)
    TeamsCardGrid(teams = teamsList )
}