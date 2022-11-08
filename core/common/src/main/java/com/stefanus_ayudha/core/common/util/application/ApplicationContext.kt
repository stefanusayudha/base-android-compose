package com.stefanus_ayudha.core.common.util.application

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