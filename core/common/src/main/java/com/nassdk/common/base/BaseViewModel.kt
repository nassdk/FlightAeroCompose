package com.nassdk.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nassdk.common.coroutines.CoroutinesDispatcherProvider
import com.nassdk.common.coroutines.error.CoroutineErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<S : BaseViewState, E : BaseViewEvent>(
    initialState: S,
    private val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider(),
) : ViewModel() {

    private val _viewState = MutableStateFlow(initialState)

    val viewState: StateFlow<S> get() = _viewState

    protected val intent =
        MutableSharedFlow<E>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    init {
        intent.onEach(::observe).launchIn(viewModelScope)
    }

    protected fun updateState(block: S.() -> S) {
        _viewState.value = block.invoke(viewState.value)
    }

    protected fun updateStateFromIo(block: S.() -> S) {
        viewModelScope.launch(context = dispatcherProvider.main) {
            _viewState.value = block.invoke(viewState.value)
        }
    }

    protected abstract fun observe(event: E)

    fun perform(viewEvent: E) = intent.tryEmit(viewEvent)

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