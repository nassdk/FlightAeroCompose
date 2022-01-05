package com.nassdk.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AeroColors(
    val primaryBackground: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val spinnerColor: Color,
    val secondaryBackground: Color,
)

object AeroTheme {
    val colors: AeroColors
        @Composable
        get() = LocalAeroColors.current
}

val LocalAeroColors = staticCompositionLocalOf<AeroColors> {
    error("No colors provided")
}