package com.tac.nba_companion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tac.nba_companion.data.datasource.TeamRemoteDataSource
import com.tac.nba_companion.data.network.dto.TeamDtoMapper
import com.tac.nba_companion.data.repository.TeamRepositoryImpl
import com.tac.nba_companion.domain.usecases.GetTeamListUseCase
import com.tac.nba_companion.ui.theme.NbaCompanionTheme
import com.tac.nba_companion.viewmodel.TeamsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = TeamsViewModel(
            getTeamListUseCase = GetTeamListUseCase(
                repository = TeamRepositoryImpl(
                    teamDtoMapper = TeamDtoMapper(),
                    dataSource =  TeamRemoteDataSource()
                )
            )
        )
        super.onCreate(savedInstanceState)

        setContent {
            NbaCompanionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TeamsScreen(viewModel = vm)
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