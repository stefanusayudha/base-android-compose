package com.singularity_code.modsample.todolist.data.payload

import com.singularity_code.core.common.data.payload.Payload

data class GetTodoListPld(
    val id: String = ""
) : Payload {
    override fun getQueryMap() = hashMapOf<String, String>()
        .apply {
            // No query payload
        }
}