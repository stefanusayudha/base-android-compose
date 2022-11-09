package com.stefanus_ayudha.core.network.util

import com.iddevops.core.network.BuildConfig.BUILD_TYPE
import com.stefanus_ayudha.core.network.util.interceptor.chuckerInterceptor
import okhttp3.OkHttpClient

fun defaultOkhttp() = OkHttpClient.Builder()
    .apply {
        if (BUILD_TYPE != "release")
            addInterceptor(chuckerInterceptor)
    }
    .build()