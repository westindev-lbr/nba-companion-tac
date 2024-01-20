package com.tac.nba_companion.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tac.nba_companion.R
import com.tac.nba_companion.presentation.home.HomeScreen
import com.tac.nba_companion.presentation.home.HomeViewModel
import com.tac.nba_companion.presentation.navigation.components.BottomNavigation
import com.tac.nba_companion.presentation.navigation.components.BottomNavigationItem
import com.tac.nba_companion.presentation.navigation.components.NbaTopAppBar
import com.tac.nba_companion.presentation.preferences.PreferencesScreen
import com.tac.nba_companion.presentation.preferences.PreferencesViewModel
import com.tac.nba_companion.presentation.results.ResultsScreen
import com.tac.nba_companion.presentation.results.ResultsViewModel
import com.tac.nba_companion.presentation.standings.StandingsScreen
import com.tac.nba_companion.presentation.standings.StandingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NbaAppNavigation() {
// remember permet de conserver l'état des variables de l'objet après la recomposition
    val bottomNavigationItem = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ico_news, text = "Teams"),
            BottomNavigationItem(icon = R.drawable.ico_standings, text = "Standings"),
            BottomNavigationItem(icon = R.drawable.ico_scores, text = "Results"),
            BottomNavigationItem(icon = R.drawable.ico_pref, text = "Preference"),
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value

    var selectedItem by rememberSaveable {
        // A chaque modification de selectedItem le composable sera recomposé
        // Valeur initiale 0 (home)
        mutableStateOf(0)
    }

    selectedItem =
        when (backstackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.StandingsScreen.route -> 1
            Route.ResultsScreen.route -> 2
            Route.PreferencesScreen.route -> 3
            else -> 0
        }

    val homeViewModel: HomeViewModel = hiltViewModel()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NbaTopAppBar(
                title = "NBA Companion",
                isGridView = homeViewModel.uiState.collectAsState().value.isGridView,
                onToggleGridView = { homeViewModel.toggleGridView() }
            )
        },
        bottomBar = {
            BottomNavigation(
                items = bottomNavigationItem,
                selected = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateOnTap(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateOnTap(
                            navController = navController,
                            route = Route.StandingsScreen.route
                        )

                        2 -> navigateOnTap(
                            navController = navController,
                            route = Route.ResultsScreen.route
                        )

                        3 -> navigateOnTap(
                            navController = navController,
                            route = Route.PreferencesScreen.route
                        )
                    }
                })
        }

    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                // Collecte de l'état à passer à la vue
                val teamsState = homeViewModel.uiState.collectAsState().value
                HomeScreen(state = teamsState)
            }


            composable(route = Route.StandingsScreen.route) {
                val viewModel: StandingsViewModel = viewModel()
                StandingsScreen()
            }

            composable(route = Route.ResultsScreen.route) {
                val viewModel: ResultsViewModel = viewModel()
                ResultsScreen()
            }

            composable(route = Route.PreferencesScreen.route) {
                val viewModel: PreferencesViewModel = viewModel()
                PreferencesScreen()
            }
        }
    }
}

private fun navigateOnTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { home ->
            popUpTo(home) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}