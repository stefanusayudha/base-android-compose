/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.pattern.viewmodel

import arrow.core.Either
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.VmError

@Deprecated(
    "Semantic correction. Soon be deleted",
    ReplaceWith("createStateHolder(operator)")
)
fun <T, P : Payload> BaseViewModel.stateCreator(
    operator: suspend (P) -> Either<VmError, T>
): BaseViewModel.State<T, P> {
    return createStateHolder(operator)
}

fun <T, P : Payload> BaseViewModel.createStateHolder(
    updateOperator: suspend (P) -> Either<VmError, T>
): BaseViewModel.State<T, P> = object : BaseViewModel.State<T, P>() {
    override val operator = updateOperator
}