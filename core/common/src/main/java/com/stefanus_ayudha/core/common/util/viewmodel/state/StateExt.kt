/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.stefanus_ayudha.core.common.util.viewmodel.state

import androidx.compose.runtime.Composable
import com.stefanus_ayudha.core.common.domain.model.Error
import com.stefanus_ayudha.core.common.util.request.Default
import com.stefanus_ayudha.core.common.util.request.Failed
import com.stefanus_ayudha.core.common.util.request.Loading
import com.stefanus_ayudha.core.common.util.request.Success
import com.stefanus_ayudha.core.common.util.viewmodel.BaseViewModel

/**
 * Be careful this function trigger recomposition.
 * Use this if you only need to handle a state one time only.
 * This function wil map state value to given response type.
 */
@Composable
fun <T, R> BaseViewModel.State<T, *>.mapState(
    default: () -> R,
    loading: () -> R,
    failed: (e: Error) -> R,
    success: (d: T) -> R
): R {
    return when (val v = value()) {
        is Default -> default.invoke()
        is Failed -> failed.invoke(v.e)
        is Loading -> loading.invoke()
        is Success -> success.invoke(v.value)
    }
}

/**
 * Be careful this function trigger recomposition.
 * Use this if you only need to handle a state one time only.
 * This function will handle each state by emitting a composable function.
 */
@Composable
fun <T> BaseViewModel.State<T, *>.onState(
    default: @Composable () -> Unit,
    loading: @Composable () -> Unit,
    failed: @Composable (e: Error) -> Unit,
    success: @Composable (d: T) -> Unit,
) {
    return when (val v = value()) {
        is Default -> default()
        is Failed -> failed(v.e)
        is Loading -> loading()
        is Success -> success(v.value)
    }
}