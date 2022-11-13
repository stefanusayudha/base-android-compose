package com.singularity_code.core.common.data.payload

interface Payload {
    fun getQueryMap(): Map<String, String> = hashMapOf()
}