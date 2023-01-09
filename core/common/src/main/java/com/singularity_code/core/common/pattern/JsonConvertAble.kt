/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.pattern

import com.google.gson.Gson
import com.google.gson.GsonBuilder

interface JsonConvertAble {
    fun toStringJSON(): String = Gson().toJson(this)
}

inline fun <reified T : JsonConvertAble> String.toObject(): T = Gson().fromJson(this, T::class.java)

fun <T> String.toObject(type: Class<T>): T {
    val gson = GsonBuilder().create()
    return gson.fromJson<T>(this, type)
}