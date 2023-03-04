package com.singularity_code.modsample.todolist.data

import arrow.core.Either
import com.singularity_code.core.common.model.VmError
import com.singularity_code.modsample.todolist.data.model.TDMDL
import com.singularity_code.modsample.todolist.data.payload.GetTodoByIdPld
import com.singularity_code.modsample.todolist.data.payload.GetTodoListPld
import com.singularity_code.modsample.todolist.data.src.web.todoListWebApi

suspend fun getTodoList(
    payload: GetTodoListPld
): Either<VmError, List<TDMDL>> {

    return todoListWebApi
        .getTodoList(
            payload.getQueryMap()
        )
        .let { res ->

            // you can handler request code here if you want
            // since you may need to handle http error and result error different way.
            // http error will only emmit message and http code,
            // while result error can contain more stuff depend to your api design.

            // this is example for general. by assuming that api error will only emit error message
            res.body
                .mapLeft {
                    VmError(
                        code = res.code,
                        message = it
                    )
                }
        }
}

suspend fun getTodoById(
    payload: GetTodoByIdPld
): Either<VmError, TDMDL> {
    return todoListWebApi
        .getTodoById(
            payload.id
        )
        .let { res ->
            res.body
                .mapLeft {
                    VmError(
                        code = res.code,
                        message = it
                    )
                }
        }
}