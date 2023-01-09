package com.singularity_code.modsample.todolist.data.payload

import com.singularity_code.core.common.pattern.Payload

data class GetTodoByIdPld(
    val id: String = ""
) : Payload {
    override fun getQueryMap() = hashMapOf<String, String>()
        .apply {
            // No query payload
        }
}