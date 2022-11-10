/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.stefanus_ayudha.core.common.util.request

import com.stefanus_ayudha.core.common.domain.model.Error

sealed class RequestState<T>
class Default<T> : RequestState<T>()
class Loading<T> : RequestState<T>()
class Success<T>(var value: T) : RequestState<T>()
class Failed<T>(val e: Error) : RequestState<T>()