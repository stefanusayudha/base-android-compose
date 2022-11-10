/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.activity

import com.stefanus_ayudha.core.common.util.bootstrap.BootstrapUseCase
import com.stefanus_ayudha.core.common.util.component.BaseComponentUseCase
import kotlinx.coroutines.Job

interface BaseActivityUseCase : BaseComponentUseCase, BootstrapUseCase {
    fun withScope(block: suspend () -> Unit): Job

    /**
     * On early create - This scope run in onCreate() before everything else.
     * This function guarantee the lifecycle is already created when it launched.
     *
     */
    fun onEarlyCreate()
}