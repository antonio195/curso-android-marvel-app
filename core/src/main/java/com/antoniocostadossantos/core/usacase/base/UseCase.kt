package com.antoniocostadossantos.core.usacase.base

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, out R> {

    operator fun invoke(params: P): Flow<ResultStatus<R>> = flow {
        emit(ResultStatus.Loading)
        emit(doWork(params))
    }.catch {
        emit(ResultStatus.Error(it))
    }

    protected abstract suspend fun doWork(params: P): ResultStatus<R>
}

abstract class PagingUseCase<in P, R : Any> {
    operator fun invoke(params: P): Flow<PagingData<R>> = createFlowObservable(params)

    protected abstract fun createFlowObservable(params: P): Flow<PagingData<R>>
}