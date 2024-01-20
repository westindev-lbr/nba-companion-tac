package com.tac.nba_companion.presentation.teamDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.usecases.GetTeamDetailUseCase
import com.tac.nba_companion.presentation.common.IErrorTypeToErrorTextConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val getTeamDetailUseCase: GetTeamDetailUseCase,
    private val errorTextConverterImpl: IErrorTypeToErrorTextConverter
) : ViewModel() {

    private val _uiState = MutableStateFlow(TeamDetailState())
    val uiState: StateFlow<TeamDetailState> = _uiState.asStateFlow()

    fun loadTeamDetail(teamId: Int) {
        viewModelScope.launch {
            getTeamDetailUseCase(teamId = teamId)
                .collect { team ->
                    when (team) {
                        is Resource.Success -> {
                            _uiState.update { currentState ->
                                currentState.copy(team = team.data, isLoading = false)
                            }
                        }

                        is Resource.Error -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    isError = true,
                                    errorText = errorTextConverterImpl.convert(team.error),
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
        }
    }
}