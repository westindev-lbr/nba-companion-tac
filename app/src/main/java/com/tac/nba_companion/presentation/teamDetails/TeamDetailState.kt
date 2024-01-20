package com.tac.nba_companion.presentation.teamDetails

import com.tac.nba_companion.domain.entities.TeamDetail
import com.tac.nba_companion.presentation.common.ErrorText

data class TeamDetailState(
    val team: TeamDetail? = null,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val errorText: ErrorText? = null,
)