package com.stefanus_ayudha.modsample.todolist.data.payload

import com.stefanus_ayudha.core.common.domain.payload.Payload

data class GetTodoByIdPayload(
    val id: String = ""
) : Payload {
    override fun getQueryMap() = hashMapOf<String, String>()
        .apply {
            // No query payload
        }
}