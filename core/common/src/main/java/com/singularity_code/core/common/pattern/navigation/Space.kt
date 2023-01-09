/*
 * Copyright (c) 2022. Stefanus Ayudha + Joseph Sanjaya.
 */
package com.singularity_code.core.common.pattern.navigation

import androidx.activity.result.contract.ActivityResultContract

interface Space<P, O> {
    fun getLauncher(): ActivityResultContract<P, O?>
}