/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ApplicationContext {
    private var context: Context? = null
    fun set(context: Context) {
        ApplicationContext.context = context
    }

    fun get(): Context {
        return context!!
    }
}