package com.tac.nba_companion.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tac.nba_companion.R
import com.tac.nba_companion.presentation.home.components.NbaTopAppBar
import com.tac.nba_companion.presentation.home.components.TeamsCardGrid
import com.tac.nba_companion.presentation.home.components.TeamsCardList

@Composable
fun HomeScreen(
    state: HomeState,
    onToggleGridView: () -> Unit,
    navigateToDetails: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        NbaTopAppBar(title = "NBA Companion", isGridView = state.isGridView, onToggleGridView = onToggleGridView )
        if (!state.isError) {
            if (!state.isGridView) {
                TeamsCardList(teams = state.teams, onClick = navigateToDetails)
            } else {
                TeamsCardGrid(teams = state.teams, onClick = navigateToDetails)
            }
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ico_error),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = state.errorText!!.asString(),
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
