@file:OptIn(ExperimentalMaterial3Api::class)

package com.tac.nba_companion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.ui.theme.NbaCompanionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NbaCompanionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { mTopAppBar() },
                        content = { paddingValues ->  Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)) },
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("myTag", "je démarre")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myTag", "je suis en cours d'exécution")
    }
    override fun onPause() {
        super.onPause()
        Log.d("myTag", "je suis en pause")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mTopAppBar() {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("NBA Companion")
            }
        )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NbaCompanionTheme {
        Greeting("Android")
    }
}