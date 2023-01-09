/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.pattern.viewmodel.state

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.pattern.VmError
import com.singularity_code.core.common.pattern.Default
import com.singularity_code.core.common.pattern.Failed
import com.singularity_code.core.common.pattern.Loading
import com.singularity_code.core.common.pattern.Success
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModel

/**
 * Be careful this function trigger recomposition.
 * Use this if you only need to handle a state one time only.
 * This function wil map state value to given response type.
 */
@Composable
fun <T, R> BaseViewModel.State<T, *>.mapState(
    default: () -> R,
    loading: () -> R,
    failed: (e: VmError) -> R,
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
    failed: @Composable (e: VmError) -> Unit,
    success: @Composable (d: T) -> Unit,
) {
    return when (val v = value()) {
        is Default -> default()
        is Failed -> failed(v.e)
        is Loading -> loading()
        is Success -> success(v.value)
    }
}