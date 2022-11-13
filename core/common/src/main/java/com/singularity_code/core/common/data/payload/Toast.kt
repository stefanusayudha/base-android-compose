package com.singularity_code.core.common.data.payload

data class Toast(
    val message: String,
    val longToast: Boolean = false
) : Payload