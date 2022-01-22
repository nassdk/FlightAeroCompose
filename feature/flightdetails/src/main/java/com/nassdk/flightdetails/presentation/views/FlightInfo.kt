Cpackage com.nassdk.flightdetails.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.nassdk.flightdetails.R
import com.nassdk.flightdetails.domain.entity.FlightEntity
import com.nassdk.flightdetails.domain.entity.FlightStatus
import com.nassdk.ui.helpers.DashedLine
import com.nassdk.ui.theme.AeroTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun FlightInfo(flight: FlightEntity) {

    Card(
        onClick = {},
        enabled = false,
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
                    .padding(vertical = AeroTheme.dimens.dp16),
                content = {
                    MainInfo(flight = flight)

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    StatusView(status = flight.status)

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.flightdetails_company_title
                        ),
                        value = "S7 Airlines"
                    )
                }
            )
        }
    )
}

@Composable
private fun MainInfo(flight: FlightEntity) {

    ConstraintLayout(
        modifier = Modifier.padding(horizontal = AeroTheme.dimens.dp16),
        content = {
            val (dateDep, dateArr) = createRefs()
            val (timeDep, timeArr, timeTotal, trajectory) = createRefs()
            val (depCity, depAirport, arrCity, arrAirport) = createRefs()

            Text(
                text = flight.arrDay,
                style = AeroTheme.typegraphy.subMedCons,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier.constrainAs(
                    ref = dateDep,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = flight.depDay,
                style = AeroTheme.typegraphy.subMedCons,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier.constrainAs(
                    ref = dateArr,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = flight.depTime,
                style = AeroTheme.typegraphy.headerMedCons,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp12)
                    .constrainAs(
                        ref = timeDep,
                        constrainBlock = {
                            start.linkTo(anchor = parent.start)
                            top.linkTo(anchor = dateDep.bottom)
                        }
                    )
            )

            Text(
                text = flight.flightTime,
                style = AeroTheme.typegraphy.subMedCons,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(bottom = AeroTheme.dimens.dp4)
                    .constrainAs(
                        ref = timeTotal,
                        constrainBlock = {
                            bottom.linkTo(anchor = timeDep.bottom)
                            start.linkTo(anchor = timeDep.end)
                            end.linkTo(anchor = timeArr.start)
                        }
                    )
            )

            Text(
                text = flight.arrTime,
                style = AeroTheme.typegraphy.headerMedCons,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp12)
                    .constrainAs(
                        ref = timeArr,
                        constrainBlock = {
                            end.linkTo(anchor = parent.end)
                            top.linkTo(anchor = dateArr.bottom)
                        }
                    )
            )

            TrajectoryView(
                ref = trajectory,
                constrainBlock = {
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    top.linkTo(anchor = timeDep.bottom)
                }
            )

            Text(
                text = flight.departureTimezone,
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = depCity,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = trajectory.bottom)
                    }
                )
            )

            Text(
                text = flight.departureTimezone,
                style = AeroTheme.typegraphy.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = depAirport,
                        constrainBlock = {
                            start.linkTo(anchor = parent.start)
                            top.linkTo(anchor = depCity.bottom)
                        }
                    )
            )

            Text(
                text = flight.arrivalTimezone,
                style = AeroTheme.typegraphy.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = arrCity,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = trajectory.bottom)
                    }
                )
            )

            Text(
                text = flight.arrivalTimezone,
                style = AeroTheme.typegraphy.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = arrAirport,
                        constrainBlock = {
                            end.linkTo(anchor = parent.end)
                            top.linkTo(anchor = depCity.bottom)
                        }
                    )
            )

        }
    )
}

@Composable
private fun ConstraintLayoutScope.TrajectoryView(
    ref: ConstrainedLayoutReference,
    constrainBlock: ConstrainScope.() -> Unit,
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(top = AeroTheme.dimens.dp16)
            .fillMaxWidth()
            .constrainAs(
                ref = ref,
                constrainBlock = constrainBlock
            ),
        content = {

            val (departure, dashedStart, plane, planeName, dashedEnd, arrival) = createRefs()

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
                    .fillMaxWidth(fraction = 0.4f)
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
                    .fillMaxWidth(fraction = 0.4f)
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

            Text(
                text = "Boeing 737",
                style = AeroTheme.typegraphy.subMedRoboto,
                color = Color(0xFFFF9A8D),
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = planeName,
                        constrainBlock = {
                            start.linkTo(anchor = plane.start)
                            end.linkTo(anchor = plane.end)
                            top.linkTo(anchor = plane.bottom)
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
private fun StatusView(status: FlightStatus) {

    Text(
        text = stringResource(id = R.string.flightdetails_status_title),
        style = AeroTheme.typegraphy.subMedRoboto,
        color = AeroTheme.colors.secondaryText,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp16,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16,
        )
    )

    Text(
        text = stringResource(id = status.value),
        style = AeroTheme.typegraphy.bodyMedRoboto,
        color = status.tint,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp8,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16,
        )
    )
}
