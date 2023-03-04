package com.singularity_code.core.common.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.singularity_code.core.common.pattern.JsonConvertible


inline fun <reified T : JsonConvertible> String.toObject(): T = Gson().fromJson(this, T::class.java)

fun <T> String.toObject(type: Class<T>): T {
    val gson = GsonBuilder().create()
    return gson.fromJson<T>(this, type)
}