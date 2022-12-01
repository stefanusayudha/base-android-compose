package com.singularity_code.core.common.data.model

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.util.gson.JsonConvertAble

@Deprecated("use VmError is recommended")
data class Error(
    @field:SerializedName("message")
    val message: String?,
    @field:SerializedName("code")
    val code: Int?
) : JsonConvertAble

data class VmError(
    @field:SerializedName("message")
    val message: String?,
    @field:SerializedName("code")
    val code: Int?
) : JsonConvertAble