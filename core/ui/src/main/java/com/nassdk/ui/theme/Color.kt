package com.nassdk.ui.theme

import androidx.compose.ui.graphics.Color

data class AeroColors(
    val headerColor: Color,
    val primaryBackground: Color,
    val primaryText: Color,
    val primaryButton: Color,
    val secondaryButton: Color,
    val secondaryText: Color,
    val spinnerColor: Color,
    val secondaryBackground: Color,
    val tintPrimary: Color,
    val tintSecondary: Color,
    val dividerColor: Color,
)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val White_F1F1F1 = Color(0xFFF1F1F1)
val Blue_4A536B = Color(0xFF4A536B)
val Blue_9099B1 = Color(0xFF9099B1)
val Gray_979797 = Color(0xFF979797)
val Gray_D8D8D8 = Color(0xFFD8D8D8)
val Orange_FF9A8D = Color(0xFFFF9A8D)

val ShimmerColorShades = listOf(
    Color.LightGray.copy(0.9f),
    Color.LightGray.copy(0.2f),
    Color.LightGray.copy(0.9f)
)