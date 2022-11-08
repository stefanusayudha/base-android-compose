package com.stefanus_ayudha.core.common.domain.model

import com.google.gson.annotations.SerializedName
import com.stefanus_ayudha.core.common.util.gson.JsonConvertAble

data class NOTHING(
    @field:SerializedName("value")
    private val value: String? = null
) : JsonConvertAble