/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.time

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun String.toDateFormat(): String? {
    val formatted = SimpleDateFormat("dd/MM/yyyy")
    return this.isoFormatToDate()?.let {
        formatted.format(it)
    }
}

fun String.toTimeFormat(): String? {
    val formatted = SimpleDateFormat("HH.mm")
    return this.isoFormatToDate()?.let {
        formatted.format(it)
    }
}

fun String.isoFormatToDate(): Date? {
    val converted = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return if (this.isNotEmpty()) converted.parse(this) else Date()
}

fun Long.toInstant(): Instant {
    return Instant.ofEpochMilli(this)
}

fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(toInstant(), ZoneId.systemDefault())
}