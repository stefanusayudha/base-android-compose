/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.common.util

import arrow.core.Either
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.singularity_code.core.common.pattern.VmError


suspend fun <T : Operation.Data> ApolloCall<T>.getOrError()
        : Either<VmError, T> {

    val response = this.execute()

    return when (val data = response.data) {
        null -> Either.Left(
            VmError(
                code = null,
                message = response.errors
                    ?.toString() ?: "Data null"
            )
        )
        else -> Either.Right(
            data
        )
    }
}