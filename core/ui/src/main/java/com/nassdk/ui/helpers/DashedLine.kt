package com.nassdk.ui.helpers

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DashedLine(color: Color, modifier: Modifier, strokeWidth: Float = 4f) {

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 10f), 0f)

    Canvas(
        modifier = modifier,
        onDraw = {
            drawLine(
                color = color,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect,
                strokeWidth = strokeWidth
            )
        }
    )
}

@Preview
@Composable
private fun DashedLinePreview() {
    DashedLine(color = Color.Blue, modifier = Modifier.height(height = 1.dp))
}