package com.nassdk.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun FlightAeroTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkPalette
    } else {
        LightPalette
    }

    CompositionLocalProvider(
        LocalAeroColors provides colors,
        LocalAeroTypography provides typography,
        content = content
    )
}