package com.stefanus_ayudha.core.common.util.viewmodel.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.stefanus_ayudha.core.common.domain.payload.Payload
import com.stefanus_ayudha.core.common.util.request.RequestState

interface StateUseCase<T, P : Payload> {
    @Composable
    fun collectAsState(): State<RequestState<T>>
    fun request(payload: P)
    fun resetClear()
    val operator: suspend (payload: P) -> T
}