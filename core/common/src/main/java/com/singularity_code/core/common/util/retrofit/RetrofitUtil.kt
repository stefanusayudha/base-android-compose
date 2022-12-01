/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.retrofit

import androidx.annotation.NonNull
import arrow.retrofit.adapter.either.EitherCallAdapterFactory
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
    .addCallAdapterFactory(EitherCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(service)