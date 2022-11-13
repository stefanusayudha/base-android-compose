/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.viewmodel.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.singularity_code.core.common.data.payload.Payload
import com.singularity_code.core.common.util.request.RequestState

interface StateUseCase<T, P : Payload> {
    @Composable
    fun collectAsState(): State<RequestState<T>>
    fun requestUpdate(payload: P)
    fun request(payload: P)
    fun resetClear()
    val operator: suspend (payload: P) -> T
}