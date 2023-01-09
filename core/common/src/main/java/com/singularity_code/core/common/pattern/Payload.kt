package com.singularity_code.core.common.pattern

interface Payload {
    fun getQueryMap(): Map<String, String> = hashMapOf()
}