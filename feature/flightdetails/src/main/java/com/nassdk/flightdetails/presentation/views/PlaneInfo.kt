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
internal fun PlaneInfo() {

    Text(
        text = stringResource(id = R.string.flightdetails_plane_info),
        style = AeroTheme.typegraphy.header2MedRoboto,
        color = AeroTheme.colors.secondaryText,
        modifier = Modifier.padding(top = AeroTheme.dimens.dp24, start = AeroTheme.dimens.dp16)
    )

    Card(
        onClick = {},
        shape = RoundedCornerShape(size = 20.dp),
        elevation = 4.dp,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        modifier = Modifier
            .padding(
                start = AeroTheme.dimens.dp16,
                end = AeroTheme.dimens.dp16,
                top = AeroTheme.dimens.dp16
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
                            id = R.string.flightdetails_full_plane_name_title
                        ), value = "Boeing 737 Classic"
                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_model_code_title
                        ), value = "B737-377"
                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_registration_model_title
                        ), value = "YR-BAC"
                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_age_title
                        ), value = "31 год"
                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_first_plane_date
                        ), value = "21.12.2009г"
                    )
                }
            )
        }
    )
}