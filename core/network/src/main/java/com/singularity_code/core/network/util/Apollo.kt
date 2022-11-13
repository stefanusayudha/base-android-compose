/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */

package com.singularity_code.core.network.util

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient

fun apolloClient(
    url: String
): ApolloClient =
    ApolloClient.Builder()
        .serverUrl(url)
        .okHttpClient(
            defaultOkhttp()
        )
        .build()