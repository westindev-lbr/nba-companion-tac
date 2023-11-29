package com.tac.nba_companion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tac.nba_companion.core.common.Resource
import com.tac.nba_companion.domain.entities.Team
import com.tac.nba_companion.domain.usecases.GetTeamListUseCase
import com.tac.nba_companion.ui.common.UiDataState
import com.tac.nba_companion.ui.resources.ErrorTypeToErrorTextConverter
import com.tac.nba_companion.ui.resources.ErrorTypeToErrorTextConverterImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TeamsViewModel(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val errorTypeToErrorTextConverter: ErrorTypeToErrorTextConverter = ErrorTypeToErrorTextConverterImpl()
) : ViewModel() {

    private val _teams = MutableStateFlow<UiDataState<List<Team>>>(UiDataState.Loading())
    val teams: StateFlow<UiDataState<List<Team>>> = _teams.asStateFlow()

    init {
        viewModelScope.launch {
            getTeamListUseCase.execute()
                .catch { }
                .collect {
                    when (it) {
                        is Resource.Success -> _teams.value = UiDataState.Loaded(it.data)
                        is Resource.Error -> _teams.value =
                            UiDataState.Error(errorTypeToErrorTextConverter.convert(it.error))
                    }
                }
        }
    }
}

