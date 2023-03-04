/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.model

import com.google.gson.annotations.SerializedName
import com.singularity_code.core.common.pattern.JsonConvertible

data class VmError(
    @field:SerializedName("message")
    val message: String?,
    @field:SerializedName("code")
    val code: Int?
) : JsonConvertible