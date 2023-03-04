/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

import android.util.Log

fun Any.logDebug(msg: String) {
    Log.d(this.javaClass.simpleName, msg)
}

fun logDebug(msg: String) {
    Log.d("NOWHERE", msg)
}