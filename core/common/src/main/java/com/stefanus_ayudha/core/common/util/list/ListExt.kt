/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.list

fun <T> List<T?>?.refineList() =
    this?.filterNotNull() ?: listOf()