package com.nassdk.flights.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nassdk.flights.R
import com.nassdk.flights.presentation.ui.FlightsListModel
import com.nassdk.ui.helpers.DashedLine
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.dimen_16
import com.nassdk.ui.theme.dimen_8

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun FlightItem(entity: FlightsListModel.Flight) {

    Card(
        onClick = { /*TODO*/ },
        enabled = false,
        shape = RoundedCornerShape(size = 20.dp),
        elevation = 4.dp,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        modifier = Modifier.fillMaxWidth(),
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = dimen_16),

                content = {

                    TrajectoryView()

                    FlightInfo(entity = entity)

                    Divider(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .background(color = AeroTheme.colors.dividerColor)
                    )

                    NavigateItem(number = entity.number)
                }
            )
        }
    )
}

@Composable
private fun TrajectoryView() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimen_16),

        content = {

            val (departure, dashedStart, plane, dashedEnd, arrival) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.icv_departure_point),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = departure,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

            DashedLine(
                color = Color(color = 0xFFAED6DC),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.3f)
                    .height(height = 1.dp)
                    .constrainAs(
                        ref = dashedStart,
                        constrainBlock = {
                            start.linkTo(anchor = departure.end)
                            top.linkTo(anchor = parent.top)
                            end.linkTo(anchor = plane.start)
                            bottom.linkTo(anchor = parent.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.icv_airplane),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = plane,
                    constrainBlock = {
                        start.linkTo(anchor = dashedStart.end)
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = dashedEnd.start)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

            DashedLine(
                color = Color(color = 0xFFAED6DC),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.45f)
                    .height(height = 1.dp)
                    .constrainAs(
                        ref = dashedEnd,
                        constrainBlock = {
                            start.linkTo(anchor = plane.end)
                            top.linkTo(anchor = parent.top)
                            end.linkTo(anchor = arrival.start)
                            bottom.linkTo(anchor = parent.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.icv_arrival_point),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = arrival,
                    constrainBlock = {
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = parent.end)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

        }
    )
}

@Composable
private fun FlightInfo(entity: FlightsListModel.Flight) {

    ConstraintLayout(
        modifier = Modifier
            .padding(top = dimen_16)
            .fillMaxWidth()
            .padding(horizontal = dimen_16),
        content = {
            val (departureCity, departureTime, arrivalCity, arrivalTime, statusTitle) = createRefs()

            Text(
                text = entity.departureTimezone,
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = departureCity,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = entity.departureTime,
                style = AeroTheme.typegraphy.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = dimen_8)
                    .constrainAs(
                        ref = departureTime,
                        constrainBlock = {
                            start.linkTo(anchor = departureCity.start)
                            top.linkTo(anchor = departureCity.bottom)
                        }
                    )
            )

            Text(
                text = entity.arrivalTimezone,
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = arrivalCity,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = entity.departureTime,
                style = AeroTheme.typegraphy.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = dimen_8)
                    .constrainAs(
                        ref = arrivalTime,
                        constrainBlock = {
                            end.linkTo(anchor = arrivalCity.end)
                            top.linkTo(anchor = arrivalCity.bottom)
                        }
                    )
            )

            Text(
                text = stringResource(id = entity.status.value),
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = entity.status.tint,
                modifier = Modifier
                    .padding(top = dimen_16)
                    .constrainAs(
                        ref = statusTitle,
                        constrainBlock = {
                            start.linkTo(anchor = departureTime.start)
                            top.linkTo(anchor = departureTime.bottom)
                        }
                    )
            )
        }
    )
}

@Composable
private fun NavigateItem(number: String) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimen_16)
            .padding(top = dimen_16),
        content = {
            val (numberTitle, goThrough, chevron) = createRefs()

            Text(
                text = "Рейс №$number",
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = numberTitle,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = "ПЕРЕЙТИ",
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier
                    .constrainAs(
                        ref = goThrough,
                        constrainBlock = {
                            top.linkTo(anchor = chevron.top)
                            end.linkTo(anchor = chevron.start)
                            bottom.linkTo(anchor = chevron.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.icv_chevron_right),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = chevron,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = parent.top)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )
        }
    )
}