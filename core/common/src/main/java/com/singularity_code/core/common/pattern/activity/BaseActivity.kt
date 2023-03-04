/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern.activity

import com.singularity_code.core.common.pattern.Bootstrap
import com.singularity_code.core.common.pattern.Component
import kotlinx.coroutines.Job

interface BaseActivity : Component, Bootstrap {
    fun withScope(block: suspend () -> Unit): Job

    /**
     * On early create - This scope run in onCreate() before everything else.
     * This function guarantee the lifecycle is already created when it launched.
     *
     */
    fun onEarlyCreate()
}