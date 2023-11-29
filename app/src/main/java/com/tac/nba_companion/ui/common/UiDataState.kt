package com.tac.nba_companion.ui.common

sealed class UiDataState<T> {
    class Loading<T>: UiDataState<T>()
    data class Error<T>(val error: ErrorText) : UiDataState<T>()
    data class Loaded<T>(val data: T): UiDataState<T>()
}