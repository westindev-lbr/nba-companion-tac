package com.tac.nba_companion.presentation.teamDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tac.nba_companion.domain.entities.TeamDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    // private val getTeamDetailUseCase: GetTeamDetailUseCase
) : ViewModel() {

    private val _teamDetail = MutableStateFlow<TeamDetail?>(null)
    val teamDetail: StateFlow<TeamDetail?> = _teamDetail.asStateFlow()

    fun loadTeamDetail(teamId: Int) {
        viewModelScope.launch {
            val result = TeamDetail(
                6,
                "Dallas Mavericks",
                location = "Dallas",
                abbreviation = "DAL",
                logo = "https://a.espncdn.com/i/teamlogos/nba/500/dal.png",
                color = "#c8102e",
                altColor = "#fdb927",
                currentRank = "3rd in Southeast Division",
                venueName = "State Farm Arena",
                venueImg = "https://a.espncdn.com/i/venues/nba/day/1827.jpg"
            )
            _teamDetail.value = result
        }
    }
}