package com.nassdk.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nassdk.profile.views.AppBar
import com.nassdk.ui.theme.AeroTheme
import com.nassdk.ui.theme.dimen_12
import com.nassdk.ui.theme.dimen_16

@Composable
fun ProfileScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            val (appBar, box, image, name, personalActions, settings) = createRefs()

            AppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 56.dp)
                    .constrainAs(
                        ref = appBar,
                        constrainBlock = {
                            top.linkTo(anchor = parent.top)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = AeroTheme.colors.secondaryBackground)
                    .height(height = 100.dp)
                    .constrainAs(
                        ref = box,
                        constrainBlock = {
                            top.linkTo(anchor = appBar.bottom)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.ic_tesla),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 38.dp)
                    .size(size = 120.dp)
                    .clip(shape = CircleShape)
                    .constrainAs(
                        ref = image,
                        constrainBlock = {
                            top.linkTo(anchor = appBar.bottom)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    )
            )

            Text(
                text = "Никола Тесла",
                style = AeroTheme.typegraphy.headerMedRoboto,
                modifier = Modifier
                    .padding(start = dimen_16, end = dimen_16, top = dimen_12)
                    .constrainAs(
                        ref = name,
                        constrainBlock = {
                            top.linkTo(anchor = image.bottom)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = dimen_16, end = dimen_16, top = 40.dp)
                    .constrainAs(
                        ref = personalActions,
                        constrainBlock = {
                            top.linkTo(anchor = name.bottom)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    ),
                content = {
                    Button(
                        onClick = { /*TODO*/ },
                        contentPadding = PaddingValues(all = dimen_16),
                        shape = RoundedCornerShape(
                            topEnd = 16.dp,
                            topStart = 16.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AeroTheme.colors.secondaryBackground
                        ),
                        content = {

                            Image(
                                painter = painterResource(id = R.drawable.icv_person),
                                contentDescription = null
                            )

                            Text(
                                text = stringResource(id = R.string.profile_my_info_btn_title),
                                style = AeroTheme.typegraphy.buttonMedRoboto,
                                color = AeroTheme.colors.secondaryButton,
                                modifier = Modifier
                                    .padding(start = dimen_12)
                                    .weight(weight = 1f)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.icv_arrow_forward),
                                contentDescription = null
                            )
                        }
                    )

                    Divider(color = AeroTheme.colors.dividerColor)

                    Button(
                        onClick = { /*TODO*/ },
                        contentPadding = PaddingValues(all = dimen_16),
                        shape = RoundedCornerShape(
                            bottomEnd = 16.dp,
                            bottomStart = 16.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AeroTheme.colors.secondaryBackground
                        ),
                        content = {

                            Image(
                                painter = painterResource(id = R.drawable.icv_heart),
                                contentDescription = null
                            )

                            Text(
                                text = stringResource(id = R.string.profile_favorites_btn_title),
                                style = AeroTheme.typegraphy.buttonMedRoboto,
                                color = AeroTheme.colors.secondaryButton,
                                modifier = Modifier
                                    .padding(start = dimen_12)
                                    .weight(weight = 1f)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.icv_arrow_forward),
                                contentDescription = null
                            )
                        }
                    )
                }
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = dimen_12, start = dimen_16, end = dimen_16)
                    .constrainAs(
                        ref = settings,
                        constrainBlock = {
                            top.linkTo(anchor = personalActions.bottom)
                            start.linkTo(anchor = parent.start)
                            end.linkTo(anchor = parent.end)
                        }
                    ),
                contentPadding = PaddingValues(all = dimen_16),
                shape = RoundedCornerShape(size = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AeroTheme.colors.secondaryBackground
                ),
                content = {

                    Image(
                        painter = painterResource(id = R.drawable.icv_settings),
                        contentDescription = null
                    )

                    Text(
                        text = stringResource(id = R.string.profile_settings_btn_title),
                        style = AeroTheme.typegraphy.buttonMedRoboto,
                        color = AeroTheme.colors.secondaryButton,
                        modifier = Modifier
                            .padding(start = dimen_12)
                            .weight(weight = 1f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icv_arrow_forward),
                        contentDescription = null
                    )
                }
            )
        }

    )
}