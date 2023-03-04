package com.singularity_code.core.common.model

import com.singularity_code.core.common.pattern.Payload

data class Toast(
    val message: String,
    val longToast: Boolean = false
) : Payload