package com.tac.nba_companion

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.tac.nba_companion.domain.entities.Team

@Composable
fun TeamsList(teams: List<Team>) {
    LazyColumn {
        items(teams) { TeamCard(it) }
    }
}