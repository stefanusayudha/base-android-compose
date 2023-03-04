/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

fun Long.toTimeFormatted(
    showHour: Boolean = true,
    showMinute: Boolean = true,
    showSecond: Boolean = true
): String {
    var s = this / 1000
    val h = s / 3600
    s -= (h * 3600)
    val m = s / 60
    s -= (m * 60)

    return with(StringBuilder()) {

        if (showHour) {
            if (h < 10) {
                append("0")
            }
            append(h)
        }

        if (showMinute) {
            if (showHour) {
                append(":")
            }

            if (m < 10) {
                append("0")
            }
            append(m)
        }

        if (showSecond) {
            if (showHour || showMinute) {
                append(":")
            }

            if (s < 10) {
                append("0")
            }
            append(s)
        }

        toString()
    }

}