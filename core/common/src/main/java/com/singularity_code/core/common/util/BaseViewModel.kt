/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.util

import arrow.core.Either
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.viewmodel.BaseViewModelAbs
import com.singularity_code.core.common.model.VmError

@Deprecated(
    "Semantic correction. Soon be deleted",
    ReplaceWith("createStateHolder(operator)")
)
fun <T, P : Payload> BaseViewModelAbs.stateCreator(
    operator: suspend (P) -> Either<VmError, T>
): BaseViewModelAbs.State<T, P> {
    return createStateHolder(operator)
}

fun <T, P : Payload> BaseViewModelAbs.createStateHolder(
    updateOperator: suspend (P) -> Either<VmError, T>
): BaseViewModelAbs.State<T, P> = object : BaseViewModelAbs.State<T, P>() {
    override val operator = updateOperator
}