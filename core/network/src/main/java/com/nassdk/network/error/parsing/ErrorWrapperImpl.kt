package com.nassdk.network.error.parsing

import dagger.Lazy
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException

@Suppress("MagicNumber", "TooGenericExceptionCaught", "SwallowedException")
internal class ErrorWrapperImpl @Inject constructor(
    private val json: Lazy<Json>,
) : ErrorWrapper {

    override fun getError(throwable: Throwable): ErrorEntity = when (throwable) {
        is IOException -> ErrorEntity.Network
        is TimeoutException -> ErrorEntity.Timeout
        is HttpException -> {
            when (throwable.code()) {
                401 -> ErrorEntity.Unauthorized
                in 400..499 -> {
                    val response = throwable.response()?.errorBody()?.string()
                    val errorNetModel = parseError(response)

                    if (errorNetModel != null)
                        ErrorEntity.CustomError(
                            message = errorNetModel.message,
                            code = errorNetModel.code
                        )
                    else ErrorEntity.Unknown
                }
                in 500..599 -> ErrorEntity.ServerError
                else -> ErrorEntity.Unknown
            }
        }
        else -> ErrorEntity.Unknown
    }

    private fun parseError(response: String?): NetworkErrorModel? = try {
        json.get().decodeFromString<NetworkErrorResponse>(
            requireNotNull(response)
        ).errorModel
    } catch (e: Exception) {
        null
    }
}