package com.tac.nba_companion.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.presentation.home.components.TeamsCardList

@Composable
fun HomeScreen(
    teams: List<Team>
)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TeamsCardList(teams = teams)
    }

}


@Preview
@Composable
fun HomeScreenPreview() {
    val team1 = Team(6, "Dallas Mavericks", location = "Dallas", abbreviation = "DAL", logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png" )
    val team2 = Team(5, "Cleveland Cavaliers", location = "Cleveland", abbreviation = "CLE", logo = "https://a.espncdn.com/i/teamlogos/nba/500/cle.png" )
    val teamsList: List<Team> = listOf(team1, team2)
    HomeScreen(teams =teamsList )
}