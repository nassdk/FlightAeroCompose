package com.nassdk.flightdetails.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nassdk.flightdetails.R
import com.nassdk.ui.theme.AeroTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Location() {

    Text(
        text = stringResource(id = R.string.flightdetails_location_title),
        style = AeroTheme.typegraphy.header2MedRoboto,
        color = AeroTheme.colors.secondaryText,
        modifier = Modifier.padding(top = AeroTheme.dimens.dp24, start = AeroTheme.dimens.dp16)
    )

    Card(
        onClick = {},
        shape = RoundedCornerShape(size = 20.dp),
        elevation = 4.dp,
        enabled = false,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        modifier = Modifier
            .padding(
                start = AeroTheme.dimens.dp16,
                end = AeroTheme.dimens.dp16,
                top = AeroTheme.dimens.dp16,
                bottom = 74.dp,
            )
            .fillMaxWidth(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = AeroTheme.dimens.dp16),
                content = {

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_latitude_title
                        ), value = "-17.05"
                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_longtitude_title
                        ),
                        value = "-145.41667"
                    )
                }
            )
        }
    )
}