package com.nassdk.flights.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nassdk.flights.R
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.dimen_12
import com.nassdk.ui.theme.dimen_16

@Composable
internal fun AppBar() {

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp),
        backgroundColor = AeroTheme.colors.secondaryBackground,
        contentPadding = PaddingValues(horizontal = dimen_16, vertical = dimen_12),
        content = {
            Text(
                text = stringResource(id = R.string.flights_header_title),
                style = AeroTheme.typegraphy.headerBoldRubik,
                color = AeroTheme.colors.headerColor,
                modifier = Modifier
                    .weight(weight = 1f)
                    .align(alignment = Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(id = R.drawable.icv_filters),
                contentDescription = null,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        },
    )
}