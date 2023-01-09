package com.singularity_code.core.common.pattern

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertAble

data class NOTHING(
    @field:SerializedName("value")
    private val value: String? = null
) : JsonConvertAble