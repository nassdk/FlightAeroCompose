package com.nassdk.network.error.parsing

interface ErrorWrapper {
    fun getError(throwable: Throwable): ErrorEntity
}