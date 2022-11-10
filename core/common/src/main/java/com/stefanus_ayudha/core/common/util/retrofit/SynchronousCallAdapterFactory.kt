/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class SynchronousCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        // if returnType is retrofit2.Call, do nothing
        return if (returnType.toString().contains("retrofit2.Call")) {
            null
        } else object : CallAdapter<Any?, Any?> {
            override fun responseType(): Type {
                return returnType
            }

            override fun adapt(call: Call<Any?>): Any {
                return try {
                    call.execute().body()
                } catch (e: Exception) {
                    throw RuntimeException(e) // do something better
                } ?: throw NullPointerException()
            }
        }
    }


    companion object {
        fun create(): CallAdapter.Factory {
            return SynchronousCallAdapterFactory()
        }
    }
}