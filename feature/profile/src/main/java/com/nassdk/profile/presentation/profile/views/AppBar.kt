package com.nassdk.profile.presentation.profile.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.nassdk.profile.R
import com.nassdk.ui.theme.AeroTheme

@Composable
internal fun AppBar(modifier: Modifier) {

    TopAppBar(
        modifier = modifier,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        contentPadding = PaddingValues(horizontal = AeroTheme.dimens.dp16,
            vertical = AeroTheme.dimens.dp12),
        content = {
            Text(
                text = stringResource(id = R.string.profile_header_title),
                style = AeroTheme.typegraphy.headerBoldRubik,
                color = AeroTheme.colors.headerColor,
                modifier = Modifier
                    .weight(weight = 1f)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    )
}