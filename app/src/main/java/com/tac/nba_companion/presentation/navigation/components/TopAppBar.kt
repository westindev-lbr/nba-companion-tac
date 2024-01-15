package com.tac.nba_companion.presentation.navigation.components

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.ui.theme.NbaCompanionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NbaTopAppBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text(title) }
    )
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NbaTopAppBarPreview() {
    NbaCompanionTheme {
        NbaTopAppBar("NBA Companion")
    }
}