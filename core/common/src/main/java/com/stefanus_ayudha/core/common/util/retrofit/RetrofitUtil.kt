/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.retrofit

import androidx.annotation.NonNull
import arrow.core.Either
import com.stefanus_ayudha.core.common.domain.model.Error
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create retrofit service
 * @author stefanus.ayudha@gmail.com
 * @param I Retrofit interface
 * @param service Class of the given Retrofit interface
 * @param httpClient OkHttp client, if you are using my codebase all u need is injecting it by parsing get() as it's param in koin module injection configuration, once you inject the core modules configuration to the Application
 * @param baseUrl Base Url of the web api
 * @return Retrofit service of the given interface
 */
fun <I> createRetrofitService(
    @NonNull service: Class<I>,
    httpClient: OkHttpClient,
    baseUrl: String,
): I = Retrofit.Builder()
    .client(httpClient)
    .baseUrl(baseUrl)
    .addCallAdapterFactory(SynchronousCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(service)

// FIXME: use this to map the response to Either<Error, T> since the EitherCallAdapterFactory is not yet ready
suspend fun <T> eitherResponseOf(block: suspend () -> T): Either<Error, T> = try {
    Either.Right(block.invoke())
} catch (e: Throwable) {
    Either.Left(
        Error(
            message = e.message.toString(),
            code = 0
        )
    )
}

// Monoid version of above responseToEither
fun <T> (() -> T).toEither(): Either<Error, T> = try {
    Either.Right(this.invoke())
} catch (e: Throwable) {
    Either.Left(
        Error(
            message = e.message.toString(),
            code = 0
        )
    )
}