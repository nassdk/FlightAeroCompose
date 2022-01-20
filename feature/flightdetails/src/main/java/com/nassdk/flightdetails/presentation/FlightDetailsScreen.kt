package com.nassdk.flightdetails.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nassdk.flightdetails.R
import com.nassdk.flightdetails.domain.entity.FlightEntity
import com.nassdk.flightdetails.presentation.views.FlightInfo
import com.nassdk.flightdetails.presentation.views.Location
import com.nassdk.flightdetails.presentation.views.PlaneInfo
import com.nassdk.ui.kit.Toolbar
import com.nassdk.ui.theme.AeroTheme

@Composable
fun FlightDetailsScreen(
    entity: FlightEntity,
    navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            Toolbar(
                title = stringResource(id = R.string.flightdetails_number, entity.number),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = AeroTheme.colors.secondaryBackground),
                backButtonListener = { navController.popBackStack() }
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                content = {

                    Content(entity = entity)

                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(size = 12.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = AeroTheme.colors.secondaryButton),
                        modifier = Modifier
                            .padding(
                                bottom = AeroTheme.dimens.dp16,
                                start = AeroTheme.dimens.dp16,
                                end = AeroTheme.dimens.dp16
                            )
                            .fillMaxWidth()
                            .height(height = 52.dp)
                            .align(alignment = Alignment.BottomCenter),
                        content = {
                            Text(
                                text = stringResource(id = R.string.flightdetails_refresh_title),
                                style = AeroTheme.typegraphy.buttonMedRoboto,
                                color = AeroTheme.colors.primaryButton
                            )
                        }
                    )
                }
            )
        }
    )
}

@Composable
private fun Content(entity: FlightEntity) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState()),
        content = {
            FlightInfo(flight = entity)
            PlaneInfo()
            Location()
        }
    )
}