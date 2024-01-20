package com.tac.nba_companion.presentation.teamDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.tac.nba_companion.domain.entities.TeamDetail
import com.tac.nba_companion.presentation.teamDetails.components.DetailAppBar

@Composable
fun TeamDetailScreen(
    team: TeamDetail,
    navigateUp: () -> Unit
) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        DetailAppBar(
            title = team.name,
            color = team.color,
            altColor = team.altColor,
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                TeamHeader(team = team)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}


@Composable
fun TeamHeader(team: TeamDetail) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = team.logo)
                    .apply(block = fun ImageRequest.Builder.() {
                        transformations(CircleCropTransformation())
                    }).build()
            ),
            contentDescription = "Coil Circular Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Nom: ${team.name}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "Id: ${team.id}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "Lieu: ${team.location}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Text(
                text = "Pos.: ${team.currentRank}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxSize(),
        )

        {

            Text(
                text = "Gym: ${team.venueName}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = team.venueImg)
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations(RoundedCornersTransformation())
                        }).build()
                ),
                contentDescription = "Coil Circular Image",
                modifier = Modifier
                    .size(300.dp)
            )
            Text(
                text = "City: ${team.venueName}",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun TeamDetailScreenPreview() {

    val team1 = TeamDetail(
        6,
        "Dallas Mavericks",
        location = "Dallas",
        abbreviation = "DAL",
        logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png",
        color = "#c8102e",
        altColor = "#fdb927",
        currentRank = "3rd in Southeast Division",
        venueName = "State Farm Arena",
        venueImg = "https://a.espncdn.com/i/venues/nba/day/1827.jpg"
    )

    fun pwet(){}
    TeamDetailScreen(team = team1, navigateUp = { pwet()})
}