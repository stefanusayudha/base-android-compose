/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import arrow.core.Either
import com.singularity_code.core.common.model.VmError
import com.singularity_code.core.common.util.viewmodel.RequestState

interface State<T, P : Payload> {
    @Composable
    fun collectAsState(): State<RequestState<T>>
    @Composable
    fun value(): RequestState<T>
    fun requestUpdate(payload: P)
    fun request(payload: P)
    fun resetClear()
    val operator: suspend (payload: P) -> Either<VmError, T>
}