/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.viewmodel

import com.stefanus_ayudha.core.common.domain.payload.Payload
import com.stefanus_ayudha.core.common.util.common.ClearAble

interface BaseViewModelUseCase : ClearAble {
    fun <P : Payload, T> createState(
        block: suspend (payload: P) -> T
    ): BaseViewModel.State<T, P>
}