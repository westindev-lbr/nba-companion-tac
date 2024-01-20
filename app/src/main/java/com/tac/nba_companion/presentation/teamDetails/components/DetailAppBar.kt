package com.tac.nba_companion.presentation.teamDetails.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(title: String, color: String, altColor: String, onBackClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(color = android.graphics.Color.parseColor(color)),
            titleContentColor = Color(color = android.graphics.Color.parseColor(altColor)),
        ),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    tint = Color(color = android.graphics.Color.parseColor(altColor))
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
        )
}