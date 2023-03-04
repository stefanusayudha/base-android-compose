package com.singularity_code.core.ui.util.material3

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val LightColorScheme = lightColorScheme(
    primary = SafetyOrange50,
    onPrimary = Neutral98,
    secondary = DodgerBlue50,
    onSecondary = Neutral10,
    background = Neutral98,
    onBackground = Neutral10,
    surface = Neutral95,
    onSurface = Neutral10,
    surfaceVariant = Neutral90,
    onSurfaceVariant = Neutral10
)

private val DarkColorScheme = darkColorScheme(
    primary = SafetyOrange50,
    onPrimary = Neutral10,
    secondary = DodgerBlue50,
    onSecondary = Neutral90,
    background = Neutral10,
    onBackground = Neutral90,
    surface = Neutral20,
    onSurface = Neutral90,
    surfaceVariant = Neutral25,
    onSurfaceVariant = Neutral90
)

@Composable
fun BaseComposeTheme(
    darkTheme: Boolean = true,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme)
                DarkColorScheme
            // dynamicDarkColorScheme(context)
            else
                LightColorScheme
            //dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}