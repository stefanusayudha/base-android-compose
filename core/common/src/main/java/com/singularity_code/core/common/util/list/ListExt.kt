/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.list

fun <T> List<T?>?.refineList() =
    this?.filterNotNull() ?: listOf()