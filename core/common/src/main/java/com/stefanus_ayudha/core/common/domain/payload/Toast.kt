package com.stefanus_ayudha.core.common.domain.payload

data class Toast(
    val message: String,
    val longToast: Boolean = false
) : Payload