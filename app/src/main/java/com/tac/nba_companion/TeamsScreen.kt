package com.tac.nba_companion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.ui.common.ErrorView
import com.tac.nba_companion.ui.common.LoadingView
import com.tac.nba_companion.ui.common.UiDataState
import com.tac.nba_companion.viewmodel.TeamsViewModel

@Composable
fun TeamsScreen(viewModel: TeamsViewModel ) {
    val uiDataState by viewModel.teams.collectAsState()
    TeamsScreen(uiDataState)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsScreen(uiDataState: UiDataState<List<Team>>) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Teams")}) }
    ) { PaddingValues ->
        Column(
            modifier = Modifier.padding(PaddingValues)
        ) {
            when (uiDataState) {
                is UiDataState.Loading -> LoadingView()
                is UiDataState.Loaded -> TeamsList(uiDataState.data)
                is UiDataState.Error -> ErrorView(uiDataState.error, {})
            }
        }
    }
}