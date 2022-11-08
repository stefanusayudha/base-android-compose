package com.stefanus_ayudha.core.network.util.interceptor

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.stefanus_ayudha.core.common.util.application.ApplicationContext

val chuckerCollector by lazy {
    ChuckerCollector(
        context = ApplicationContext.get(),
        // Toggles visibility of the notification
        showNotification = true,
        // Allows to customize the retention period of collected data
        retentionPeriod = RetentionManager.Period.ONE_HOUR
    )
}

val chuckerInterceptor by lazy {
    ChuckerInterceptor.Builder(context = ApplicationContext.get())
        // The previously created Collector
        .collector(chuckerCollector)
        // The max body content length in bytes, after this responses will be truncated.
        .maxContentLength(250_000L)
        // List of headers to replace with ** in the Chucker UI
        // .redactHeaders("Auth-Token", "Bearer")
        // Read the whole response body even when the client does not consume the response completely.
        // This is useful in case of parsing errors or when the response body
        // is closed before being read like in Retrofit with Void and Unit types.
        .alwaysReadResponseBody(true)
        // Use decoder when processing request and response bodies. When multiple decoders are installed they
        // are applied in an order they were added.
        // .addBodyDecoder(decoder)
        // Controls Android shortcut creation. Available in SNAPSHOTS versions only at the moment
        // .createShortcut(true)
        .build()
}