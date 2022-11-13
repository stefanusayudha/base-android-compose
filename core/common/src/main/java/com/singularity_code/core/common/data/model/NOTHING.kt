package com.singularity_code.core.common.data.model

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.util.gson.JsonConvertAble

data class NOTHING(
    @field:SerializedName("value")
    private val value: String? = null
) : JsonConvertAble