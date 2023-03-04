/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern

import com.google.gson.Gson

interface JsonConvertible {
    fun toStringJSON(): String = Gson().toJson(this)
}