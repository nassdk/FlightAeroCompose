package com.nassdk.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
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
    val dividerColor: Color
)

object AeroTheme {
    val colors: AeroColors
        @Composable
        get() = LocalAeroColors.current

    val typegraphy: AeroTypography
        @Composable
        get() = LocalAeroTypography.current
}

val LocalAeroColors = staticCompositionLocalOf<AeroColors> {
    error("No colors provided")
}

val LocalAeroTypography = staticCompositionLocalOf<AeroTypography> {
    error("No colors provided")
}