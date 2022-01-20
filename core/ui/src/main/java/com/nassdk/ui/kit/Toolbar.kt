package com.nassdk.ui.kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.nassdk.ui.R
import com.nassdk.ui.theme.AeroTheme

@Composable
fun Toolbar(
    title: String,
    modifier: Modifier = Modifier,
    backButtonListener: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        content = {
            IconButton(
                onClick = { backButtonListener.invoke() },
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.icv_arrow_back),
                        contentDescription = null
                    )
                }
            )

            Text(
                text = title,
                style = AeroTheme.typegraphy.headerMedRoboto,
                color = AeroTheme.colors.headerColor,
                modifier = Modifier
                    .padding(start = AeroTheme.dimens.dp16)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    )
}