package com.tac.nba_companion.presentation.common

import com.tac.nba_companion.R
import com.tac.nba_companion.core.common.ErrorType


interface IErrorTypeToErrorTextConverter {
    fun convert(errorType: ErrorType): ErrorText
}

class ErrorTypeToErrorTextConverterImpl : IErrorTypeToErrorTextConverter {
    override fun convert(errorType: ErrorType) =
        when (errorType) {
            ErrorType.Api.NotFound -> ErrorText.StringResource(R.string.error_resource_not_found)
            ErrorType.Api.ServiceUnavailable -> ErrorText.StringResource(R.string.error_service_unavailable)
            ErrorType.Api.Server -> ErrorText.StringResource(R.string.error_server)
            ErrorType.Api.Network -> ErrorText.StringResource(R.string.error_network_unavailable)
            ErrorType.Unknown -> ErrorText.StringResource(R.string.error_general)
        }
}