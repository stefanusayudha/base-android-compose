package com.singularity_code.core.common.pattern

data class Toast(
    val message: String,
    val longToast: Boolean = false
) : Payload