/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.handler


interface BackPressHandler {
    fun onBackPress()
    fun isActive(): Boolean
}