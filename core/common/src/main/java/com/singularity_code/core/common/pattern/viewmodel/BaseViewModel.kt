/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern.viewmodel

import arrow.core.Either
import com.singularity_code.core.common.pattern.ClearAble
import com.singularity_code.core.common.pattern.Payload
import com.singularity_code.core.common.model.VmError

interface BaseViewModel : ClearAble {
    fun <P : Payload, T> createState(
        block: suspend (payload: P) -> Either<VmError, T>
    ): BaseViewModelAbs.State<T, P>
}