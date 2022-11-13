/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.viewmodel

import com.singularity_code.core.common.data.payload.Payload
import com.singularity_code.core.common.util.common.ClearAble

interface BaseViewModelUseCase : ClearAble {
    fun <P : Payload, T> createState(
        block: suspend (payload: P) -> T
    ): BaseViewModel.State<T, P>
}