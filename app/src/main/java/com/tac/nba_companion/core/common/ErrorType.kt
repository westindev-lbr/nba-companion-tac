package com.tac.nba_companion.core.common

sealed class ErrorType {

    sealed class Api: ErrorType() {
        object Network: Api()
        object ServiceUnavailable : Api()
        object NotFound : Api()
        object Server : Api()

    }

    object Unknown: ErrorType()
}