package com.tac.nba_companion.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.tac.nba_companion.domain.entities.Team


@Composable
fun CardElevation(
    team: Team,
    onClick: (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick?.invoke() },
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
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

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colorScheme.inverseSurface
                ) {
                    Text(
                        text = team.abbreviation,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                    )
                }

                Text(
                    text = team.name,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Lieu : ${team.location}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall,
                )

            }
        }
    }
}


@Composable
fun CardGridElevation(
    team: Team,
    onClick: (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick?.invoke() },
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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

            Spacer(modifier = Modifier.width(2.dp))

            Surface(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.wrapContentSize(),
                color = MaterialTheme.colorScheme.inverseSurface
            ) {
                Text(
                    text = team.abbreviation,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }

            Text(
                text = team.name,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Lieu : ${team.location}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall,
            )


        }
    }
}


@Preview
@Composable
fun CardElevationPreviw() {
    val team1 = Team(
        6,
        "Dallas Mavericks",
        location = "Dallas",
        abbreviation = "DAL",
        logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png"
    )
    CardElevation(team = team1)
}


@Preview
@Composable
fun CardGridElevationPreview() {
    val team1 = Team(
        6,
        "Dallas Mavericks",
        location = "Dallas",
        abbreviation = "DAL",
        logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png"
    )
    CardGridElevation(team = team1)
}