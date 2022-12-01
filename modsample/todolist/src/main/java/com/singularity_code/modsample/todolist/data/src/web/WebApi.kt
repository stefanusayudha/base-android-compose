package com.singularity_code.modsample.todolist.data.src.web

import arrow.retrofit.adapter.either.ResponseE
import com.singularity_code.core.common.util.retrofit.createRetrofitService
import com.singularity_code.core.network.data.Secured
import com.singularity_code.core.network.util.defaultOkhttp
import com.singularity_code.modsample.todolist.data.model.TDMDL
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TodoListApi {
    @GET("todos/")
    suspend fun getTodoList(
        @QueryMap queries: HashMap<String, String>
    ): ResponseE<String, List<TDMDL>>

    @GET("todos/{id}")
    suspend fun getTodoById(
        @Path("id") id: String
    ): ResponseE<String,TDMDL>
}

val todoListWebApi by lazy {
    createRetrofitService(
        TodoListApi::class.java,
        defaultOkhttp(),
        Secured.getBaseUrl()
    )
}