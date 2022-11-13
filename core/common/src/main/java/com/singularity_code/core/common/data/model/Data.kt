package com.singularity_code.core.common.data.model

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @field:SerializedName("data")
    val data: T?
)