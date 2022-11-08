package com.stefanus_ayudha.core.ui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Title1 = TextStyle(
    fontFamily = FontInter500,
    fontSize = sp36,
    lineHeight = sp52
)

val Title2 = TextStyle(
    fontFamily = FontInter500,
    fontSize = sp24,
    lineHeight = sp36
)

val Title3 = TextStyle(
    fontFamily = FontInter500,
    fontSize = sp20,
    lineHeight = sp32
)

val Subtitle = TextStyle(
    fontFamily = FontInter600,
    fontSize = sp18,
    lineHeight = sp26
)

val TextLarge = TextStyle(
    fontFamily = FontInter500,
    fontSize = sp16,
    lineHeight = sp24
)

val RegularStandard = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp14,
    lineHeight = sp20
)

val RegularStrikeThrough = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp14,
    lineHeight = sp20,
    textDecoration = TextDecoration.LineThrough
)

val RegularEmphasize = TextStyle(
    fontFamily = FontInter600,
    fontSize = sp14,
    lineHeight = sp20
)

val SmallStandard = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp13,
    lineHeight = sp18
)

val SmallStrikeThrough = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp13,
    lineHeight = sp18,
    textDecoration = TextDecoration.LineThrough
)

val SmallEmphasize = TextStyle(
    fontFamily = FontInter500,
    fontSize = sp13,
    lineHeight = sp18
)

val SuperSmallStandard = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp12,
    lineHeight = sp16
)

val SuperSmallStrikeThrough = TextStyle(
    fontFamily = FontInter300,
    fontSize = sp12,
    lineHeight = sp16,
    textDecoration = TextDecoration.LineThrough
)

val SuperSmallEmphasize = TextStyle(
    fontFamily = FontInter600,
    fontSize = sp12,
    lineHeight = sp16
)

val Micro = TextStyle(
    fontFamily = FontInter600,
    fontSize = sp10,
    lineHeight = sp14
)

val Button = TextStyle(
    fontFamily = FontInter600,
    fontSize = sp14,
    lineHeight = sp20
)