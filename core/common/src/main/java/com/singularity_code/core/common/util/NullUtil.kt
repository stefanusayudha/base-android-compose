/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

fun <T> withNotNull(entity: T?, block: (T) -> Unit) {
    entity?.apply {
        block.invoke(this)
    }
}
