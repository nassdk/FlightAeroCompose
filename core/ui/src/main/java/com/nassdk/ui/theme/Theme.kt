package com.nassdk.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object AeroTheme {
    val colors: AeroColors
        @Composable
        get() = LocalAeroColors.current

    val typegraphy: AeroTypography
        @Composable
        get() = LocalAeroTypography.current

    val dimens: AeroDimens
        @Composable
        get() = LocalAeroDimens.current
}

val LocalAeroColors = staticCompositionLocalOf<AeroColors> {
    error("No colors provided")
}

val LocalAeroTypography = staticCompositionLocalOf<AeroTypography> {
    error("No typography provided")
}

val LocalAeroDimens = staticCompositionLocalOf<AeroDimens> {
    error("No dimens provided")
}