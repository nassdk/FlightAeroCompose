package com.nassdk.common.coroutines.error

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineExceptionHandler

internal class CoroutineErrorHandler(
    private val exceptionListener: (() -> Unit)? = null,
) : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
//        val error = CoreErrorHandler.handleException(throwable = exception)
//        exceptionListener?.invoke(error)
    }
}