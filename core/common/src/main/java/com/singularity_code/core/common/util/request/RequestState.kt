/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.request

import com.singularity_code.core.common.data.model.VmError

sealed class RequestState<T>
class Default<T> : RequestState<T>()
class Loading<T> : RequestState<T>()
class Success<T>(var value: T) : RequestState<T>()
class Failed<T>(val e: VmError) : RequestState<T>()