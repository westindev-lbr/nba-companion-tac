package com.tac.nba_companion.presentation.navigation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tac.nba_companion.R
import com.tac.nba_companion.ui.theme.NbaCompanionTheme

// Fonction Composable
// Permet d'imbriquer d'autres composants UI et de les paramétrer
@Composable
fun BottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    )
    {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    selectedTextColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = colorResource(id = R.color.purple_200),
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )

            )
        }
    }
}

// Classe de donnée d'un item de navigation
data class BottomNavigationItem(
    // Assure que la propriété est bien une référence à une ressource drawable
    @DrawableRes val icon: Int,
    val text: String,
)

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BottomNavigationPreview() {
    NbaCompanionTheme {
        BottomNavigation(
            items = listOf(
                BottomNavigationItem(icon = R.drawable.ico_news, text = "Home"),
                BottomNavigationItem(icon = R.drawable.ico_standings, text = "Standings"),
                BottomNavigationItem(icon = R.drawable.ico_scores, text = "Results"),
                BottomNavigationItem(icon = R.drawable.ico_pref, text = "Preference"),
            ),
            selected = 2,
            onItemClick = {},
        )
    }
}