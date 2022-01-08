package com.nassdk.flights.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.nassdk.ui.animation.ShimmerAnimation

@Composable
internal fun LoadingScreen() {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            repeat(
                times = 8,
                action = {
                    item {
                        ShimmerAnimation(
                            content = { brush ->
                                ShimmerItem(brush = brush)
                            }
                        )
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ShimmerItem(brush: Brush) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 200.dp)
            .background(brush = brush, shape = RoundedCornerShape(size = 20.dp))
    )
}