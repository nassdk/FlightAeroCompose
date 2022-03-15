package com.nassdk.flights.presentation.list.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nassdk.ui.theme.AeroTheme

@Composable
internal fun LoadingItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 54.dp),
        contentAlignment = Alignment.Center,
        content = {
            CircularProgressIndicator(
                strokeWidth = 3.dp,
                color = AeroTheme.colors.tintPrimary,
                modifier = Modifier.size(size = 32.dp)
            )
        }
    )
}