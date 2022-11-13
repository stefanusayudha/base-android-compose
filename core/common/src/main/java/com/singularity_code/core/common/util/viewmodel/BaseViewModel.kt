/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.viewmodel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singularity_code.core.common.data.model.Error
import com.singularity_code.core.common.data.payload.Payload
import com.singularity_code.core.common.util.request.*
import com.singularity_code.core.common.util.retrofit.eitherResponseOf
import com.singularity_code.core.common.util.viewmodel.state.StateUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), BaseViewModelUseCase {

    abstract inner class State<T, P : Payload> : StateUseCase<T, P> {
        private val state = MutableStateFlow<RequestState<T>>(Default())
        private var job: Job? = null

        private val streamSuperVisor = SupervisorJob()
        private val handler: (onError: ((c: CoroutineContext, e: Throwable) -> Unit)?) -> CoroutineExceptionHandler =
            {
                CoroutineExceptionHandler { coroutineContext, throwable ->
                    it?.invoke(coroutineContext, throwable)
                        ?: run {
                            Log.e(
                                "${coroutineContext::class.simpleName}",
                                "launchJob: ${throwable.localizedMessage}"
                            )
                        }
                }
            }

        private val streamScope = CoroutineScope(
            streamSuperVisor
                    + Dispatchers.IO
                    + handler { c, e ->
                state.value = Failed(
                    Error(
                        message = e.message.toString(),
                        code = 0
                    )
                )
            })

        @Composable
        override fun collectAsState() = state.collectAsState()

        /**
         * warning: this function trigger recomposition
         */
        @Composable
        fun value() = collectAsState().value

        override fun requestUpdate(payload: P) {
            state.value = Loading()
            job?.cancel()
            job = viewModelScope.launch(
                streamSuperVisor +
                        Dispatchers.IO +
                        handler { c, e ->
                            state.value = Failed(
                                Error(
                                    message = e.message.toString(),
                                    code = 0
                                )
                            )
                        }
            ) {
                state.value = eitherResponseOf { operator(payload) }.fold(
                    ifLeft = { Failed(it) },
                    ifRight = { Success(it) }
                )
            }
        }

        @Deprecated("Semantic correction. Soon be deleted.", ReplaceWith("requestUpdate(payload)"))
        override fun request(payload: P) {
            requestUpdate(payload)
        }

        override fun resetClear() {
            job?.cancel()
            state.value = Default()
        }

        /**
         * Operator will handle state update request
         * @param payload : Payload.
         */
        abstract override val operator: suspend (payload: P) -> T
    }

    override fun <P : Payload, T> createState(
        block: suspend (payload: P) -> T
    ): BaseViewModel.State<T, P> {
        return object : State<T, P>() {
            override val operator: suspend (payload: P) -> T
                get() = { block.invoke(it) }
        }
    }

    abstract override fun clear()
}