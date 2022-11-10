/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.nullable

fun <T> withNotNull(entity: T?, block: (T) -> Unit) {
    entity?.apply {
        block.invoke(this)
    }
}
