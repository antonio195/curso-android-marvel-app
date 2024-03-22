package com.antoniocostadossantos.core.usacase.base

sealed class ResultStatus<out T> {

    object Loading : ResultStatus<Nothing>()
    data class Sucess<out T>(val data: T) : ResultStatus<T>()
    data class Error(val throwable: Throwable) : ResultStatus<Nothing>()

    override fun toString(): String {
        return when (this) {
            Loading -> "Loading"
            is Sucess<*> -> "Sucess[data=$data]"
            is Error -> "Sucess[data=$throwable]"
        }
    }
}