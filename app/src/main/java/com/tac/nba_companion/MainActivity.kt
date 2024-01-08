@file:OptIn(ExperimentalMaterial3Api::class)

package com.tac.nba_companion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.presentation.navigation.NbaAppNavigation
import com.tac.nba_companion.ui.theme.NbaCompanionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NbaCompanionTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.background(
                    color = MaterialTheme.colorScheme.background)
                ) {
                    NbaAppNavigation()
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