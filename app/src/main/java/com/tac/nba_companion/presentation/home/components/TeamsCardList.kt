package com.tac.nba_companion.presentation.home.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.domain.entities.Team

@Composable
fun TeamsCardList(
    teams: List<Team>,
    onClick: (Int) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        ) {
        items(
            count = teams.size

        ) {
            teams[it].let { team ->
                CardElevation(team = teams[it], onClick = { onClick(team.id)})
            }
        }
    }
}

@Preview
@Composable
fun TeamsCardListPreview(
) {
    val team1 = Team(6, "Dallas Mavericks", location = "Dallas", abbreviation = "DAL", logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png" )
    val team2 = Team(5, "Cleveland Cavaliers", location = "Cleveland", abbreviation = "CLE", logo = "https://a.espncdn.com/i/teamlogos/nba/500/cle.png" )
    val teamsList: List<Team> = listOf(team1, team2)
    TeamsCardList(teams = teamsList, onClick = { Log.d("onclik","") } )
}