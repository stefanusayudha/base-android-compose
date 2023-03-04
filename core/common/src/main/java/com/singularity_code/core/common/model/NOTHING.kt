package com.singularity_code.core.common.model

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertible

data class NOTHING(
    @field:SerializedName("value")
    private val value: String? = null
) : JsonConvertible