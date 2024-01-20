package com.tac.nba_companion.presentation.navigation

sealed class Route(
    val route: String
) {
    object HomeScreen : Route(route = "home")
    object StandingsScreen : Route(route = "standings")
    object ResultsScreen : Route(route = "results")
    object PreferencesScreen : Route(route = "preferences")
    object TeamDetailsScreen : Route(route = "team")
}