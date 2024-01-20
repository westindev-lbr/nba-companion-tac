package com.tac.nba_companion.presentation.navigation.components

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.R
import com.tac.nba_companion.ui.theme.NbaCompanionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NbaTopAppBar(title: String, isGridView: Boolean,  onToggleGridView: () -> Unit) {
    // État pour le toggle
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text(title) },
        actions = {
            // IconButton pour le toggle
            IconButton(onClick = onToggleGridView) {
                // Icône qui change en fonction de l'état
                Icon(
                    imageVector = if (isGridView) ImageVector.vectorResource(id = R.drawable.ico_list_view)
                    else ImageVector.vectorResource(id = R.drawable.ico_grid_view),
                    contentDescription = "Toggle View"
                )
            }
        }
    )
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NbaTopAppBarPreview() {
    var isGrid = false
    fun pwet() {
        isGrid = !isGrid
    }
    NbaCompanionTheme {
        NbaTopAppBar("NBA Companion", isGrid, { pwet() })
    }
}