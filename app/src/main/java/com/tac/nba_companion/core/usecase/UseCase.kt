package com.tac.nba_companion.core.usecase

/*
abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = MainScope(),
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch {
            val deferredJob = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferredJob.await())
        }
    }

    */
/**
     * class Helper qui représente Aucun
     * Paramètre quand le use case n'en
     * a pas besoin.
     *
     * @see UseCase
     *//*

    class None
}*/
