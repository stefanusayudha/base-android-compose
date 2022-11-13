package com.singularity_code.core.ui.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singularity_code.core.ui.ScreenSpec

/**
 * these extensions design to automatically scale it self, respect to
 * ScreenSpec configuration.
 * @see com.singularity_code.core.ui.ScreenSpec
 */
val Int.toDp: Dp
    get() = if (ScreenSpec.isTablet) this.dp * ScreenSpec.scale else this.dp

/**
 * these extensions design to automatically scale it self, respect to
 * ScreenSpec configuration.
 * @see com.singularity_code.core.ui.ScreenSpec
 */
val Int.toSp: TextUnit
    get() = if (ScreenSpec.isTablet) this.sp * ScreenSpec.scale else this.sp