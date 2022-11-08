package com.stefanus_ayudha.modsample.todolist.data.model

import com.google.gson.annotations.SerializedName

data class Todo(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("completed")
    val completed: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("userId")
    val userId: String? = null
) {
    companion object {
        val MOCK_LIST = (1..10).map {
            Todo(
                id = it,
                completed = it % 3 == 0,
                title = "Todo Number $it",
                userId = "User $it"
            )
        }
    }
}
