/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.util

import androidx.compose.runtime.Composable
import com.singularity_code.core.common.model.VmError
import com.singularity_code.core.common.pattern.State
import com.singularity_code.core.common.util.viewmodel.Default
import com.singularity_code.core.common.util.viewmodel.Failed
import com.singularity_code.core.common.util.viewmodel.Loading
import com.singularity_code.core.common.util.viewmodel.Success

/**
 * Be careful this function trigger recomposition.
 * Use this if you only need to handle a state one time only.
 * This function wil map state value to given response type.
 */

@Deprecated("Warning: this method arguments is not yet immutable arguments, so becareful when using it.")
@Composable
fun <T, R> State<T, *>.mapState(
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
fun <T> State<T, *>.onState(
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