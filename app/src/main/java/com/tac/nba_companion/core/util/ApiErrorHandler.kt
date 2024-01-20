package com.tac.nba_companion.core.util

import com.tac.nba_companion.core.common.ErrorType
import com.tac.nba_companion.core.common.Resource
import retrofit2.Response

/**
 * Méthode utilitaire pour retourner les types d'érreurs de la classe scéllé ErrorType
 * en fonctions des codes HTTP retourné par Response de retrofit
 */
object ApiErrorHandler {
    fun <T> handleErrorResponse(response: Response<*>): Resource.Error<T> {
        val errorType = when {
            response.code() == 404 -> ErrorType.Api.NotFound
            response.code() == 503 -> ErrorType.Api.ServiceUnavailable
            response.code() >= 500 -> ErrorType.Api.Server
            else -> ErrorType.Unknown
        }
        return Resource.Error<T>(errorType)
    }
}