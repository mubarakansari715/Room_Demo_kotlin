package com.mubarak.room_demo_kotlin.utils

import kotlinx.coroutines.flow.*


inline fun <ResultType, RequestType> networkboundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {
    val data = query().first()

    val flowData = if (shouldFetch(data)) {
        emit(ApiState.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { ApiState.Success(it) }
        } catch (throwable: Throwable) {
            query().map { ApiState.Error(throwable, it) }
        }
    } else {
        query().map { ApiState.Success(it) }
    }

    emitAll(flowData)
}