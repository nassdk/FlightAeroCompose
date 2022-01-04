package com.nassdk.network.error.parsing

sealed class ErrorEntity {
    object Unknown : ErrorEntity()
    object Timeout : ErrorEntity()
    object ServerError : ErrorEntity()
    object Network : ErrorEntity()
    object Unauthorized : ErrorEntity()
    data class CustomError(val message: String, val code: Int) : ErrorEntity()
}