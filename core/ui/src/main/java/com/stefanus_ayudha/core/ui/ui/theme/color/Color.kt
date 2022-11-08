package com.stefanus_ayudha.core.ui.ui.theme.color

import androidx.compose.ui.graphics.Color

val PrimaryGreen = Color(0xFF006551)
val PrimaryMagenta = Color(0xFFE22153)
val PrimaryYellow = Color(0xFFFCAD10)
val PrimaryCream = Color(0xFFFBEFDD)
val PrimaryGray = Color(0xFFF8F7F5)

val Gray100 = Color(0xFFFAFAFA)
val Gray200 = Color(0xFFF5F5F5)
val Gray300 = Color(0xFFEBEBEB)
val Gray400 = Color(0xFFBDBDBD)
val Gray500 = Color(0xFF9E9E9E)
val Gray600 = Color(0xFF555555)
val Gray700 = Color(0xFF1A1A1A)

val NeutralBlack = Color(0xFF000000)
val NeutralWhite = Color(0xFFFFFFFF)

/** INFO **/
val Info = SemanticColor(
    darker = Color(0xFF09509D),
    dark = Color(0xFF2371C6),
    default = Color(0xFF4393EA),
    light = Color(0xFFD3E5FA),
    lighter = Color(0xFFF0F7FF)
)
val Positive = SemanticColor(
    darker = Color(0xFF0B6732),
    dark = Color(0xFF19954D),
    default = Color(0xFF27AE60),
    light = Color(0xFFBEF0D3),
    lighter = Color(0xFFE3F6EB)
)
val Warning = SemanticColor(
    darker = Color(0xFF904E01),
    dark = Color(0xFFD97A0B),
    default = Color(0xFFFF8A00),
    light = Color(0xFFFFE7CA),
    lighter = Color(0xFFFFF8EF)
)
val Danger = SemanticColor(
    darker = Color(0xFF76102B),
    dark = Color(0xFFAF2631),
    default = Color(0xFFCC3434),
    light = Color(0xFFEF9784),
    lighter = Color(0xFFFCE3D6)
)

val ButtonNormal = PrimaryGreen
val ButtonHovered = Color(0xB3006551)
val ButtonPressed = Color(0x66006551)
val ButtonDisabled = Gray300
val ButtonLoading = PrimaryGreen