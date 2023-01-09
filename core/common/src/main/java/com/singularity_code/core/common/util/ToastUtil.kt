/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util

import android.widget.Toast.makeText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.singularity_code.core.common.pattern.Toast


@Composable
fun MakeToast(payload: Toast) = makeText(
    LocalContext.current.applicationContext,
    payload.message,
    if (payload.longToast)
        android.widget.Toast.LENGTH_LONG
    else android.widget.Toast.LENGTH_SHORT
).show()