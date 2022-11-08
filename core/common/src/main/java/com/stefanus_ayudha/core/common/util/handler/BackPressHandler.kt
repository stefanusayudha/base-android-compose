package com.stefanus_ayudha.core.common.util.handler


interface BackPressHandler {
    fun onBackPress()
    fun isActive(): Boolean
}