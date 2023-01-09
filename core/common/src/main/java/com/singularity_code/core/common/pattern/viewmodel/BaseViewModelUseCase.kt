/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern.viewmodel

import arrow.core.Either
import com.singularity_code.core.common.pattern.VmError
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.pattern.ClearAble

interface BaseViewModelUseCase : ClearAble {
    fun <P : Payload, T> createState(
        block: suspend (payload: P) -> Either<VmError, T>
    ): BaseViewModel.State<T, P>
}