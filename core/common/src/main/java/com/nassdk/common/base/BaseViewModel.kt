package com.nassdk.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nassdk.common.coroutines.CoroutinesDispatcherProvider
import com.nassdk.common.coroutines.error.CoroutineErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<S : BaseViewState, E : BaseViewEvent>(
    initialState: S,
    private val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider(),
) : ViewModel() {

    private val state = MutableStateFlow(initialState)

    protected val viewState
        get() = state.asStateFlow().filterNotNull()

    protected val intent =
        MutableSharedFlow<E>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    init {
        intent.onEach(::observe).launchIn(viewModelScope)
    }

    protected fun updateState(block: S.() -> S) {
        state.value = block.invoke(state.value)
    }

    protected abstract fun observe(event: E)

    fun perform(viewEvent: E) = intent.tryEmit(viewEvent)
    fun viewState(): Flow<S> = viewState

    protected fun launchCoroutine(
        exceptionListener: (() -> Unit)? = null,
        function: suspend CoroutineScope.() -> Unit,
    ): Job {
        return viewModelScope.launch(
            CoroutineErrorHandler(
                exceptionListener = exceptionListener
            )
        ) {
            function()
        }
    }

    protected fun launchIOCoroutine(
        exceptionListener: (() -> Unit)? = null,
        function: suspend CoroutineScope.() -> Unit,
    ): Job {
        return launchCoroutine(exceptionListener = exceptionListener) {
            withContext(dispatcherProvider.io) {
                function()
            }
        }
    }
}