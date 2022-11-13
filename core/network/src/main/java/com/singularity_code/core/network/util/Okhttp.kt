/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.network.util

import com.iddevops.core.network.BuildConfig.BUILD_TYPE
import com.singularity_code.core.network.util.interceptor.chuckerInterceptor
import okhttp3.OkHttpClient

fun defaultOkhttp() = OkHttpClient.Builder()
    .apply {
        if (BUILD_TYPE != "release")
            addInterceptor(chuckerInterceptor)
    }
    .build()