package com.singularity_code.core.common.data.model

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.util.gson.JsonConvertAble

data class Error(
    @field:SerializedName("message")
    val message: String?,
    @field:SerializedName("code")
    val code: Int?
) : JsonConvertAble