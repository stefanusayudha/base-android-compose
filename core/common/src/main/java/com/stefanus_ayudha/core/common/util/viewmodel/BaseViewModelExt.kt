/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.stefanus_ayudha.core.common.util.viewmodel

import com.stefanus_ayudha.core.common.domain.payload.Payload

@Deprecated(
    "Semantic correction. Soon be deleted",
    ReplaceWith("createStateHolder(operator)")
)
fun <T, P : Payload> BaseViewModel.stateCreator(
    operator: suspend (P) -> T
): BaseViewModel.State<T, P> {
    return createStateHolder(operator)
}

fun <T, P : Payload> BaseViewModel.createStateHolder(
    updateOperator: suspend (P) -> T
): BaseViewModel.State<T, P> = object : BaseViewModel.State<T, P>() {
    override val operator = updateOperator
}