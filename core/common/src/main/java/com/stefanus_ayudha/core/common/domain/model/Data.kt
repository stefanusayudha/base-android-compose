package com.stefanus_ayudha.core.common.domain.model

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @field:SerializedName("data")
    val data: T?
)