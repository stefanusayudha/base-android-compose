package com.stefanus_ayudha.core.common.domain.payload

interface Payload {
    fun getQueryMap(): Map<String, String> = hashMapOf()
}