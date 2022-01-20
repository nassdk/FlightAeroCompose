package com.nassdk.flightdetails.presentation.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nassdk.ui.theme.AeroTheme

@Composable
internal fun InfoElement(title: String, value: String) {

    Text(
        text = title,
        style = AeroTheme.typegraphy.subMedRoboto,
        color = AeroTheme.colors.secondaryText,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp16,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16
        )
    )

    Text(
        text = value,
        style = AeroTheme.typegraphy.bodyMedRoboto,
        color = AeroTheme.colors.primaryText,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp8,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16,
        )
    )
}