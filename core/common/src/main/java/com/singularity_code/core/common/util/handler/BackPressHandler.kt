/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.handler


interface BackPressHandler {
    fun onBackPress()
    fun isActive(): Boolean
}