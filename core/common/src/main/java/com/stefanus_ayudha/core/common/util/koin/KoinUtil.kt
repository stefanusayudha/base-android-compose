/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.koin

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <reified T> get(): T {
    val koinObj = object : KoinComponent {
        val instance: T by inject()
    }
    return koinObj.instance
}