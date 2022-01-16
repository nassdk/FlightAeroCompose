package com.nassdk.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.nassdk.settings.domain.entity.SettingsBundle
import com.nassdk.ui.theme.AeroTheme

@Composable
fun SettingsScreen(
    navController: NavHostController,
    settingsState: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.secondaryBackground),
    ) {

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AeroTheme.colors.secondaryBackground),
            backgroundColor = AeroTheme.colors.secondaryBackground,
            content = {
                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.icv_arrow_back),
                            contentDescription = null
                        )
                    }
                )

                Text(
                    text = stringResource(id = R.string.settings_title),
                    style = AeroTheme.typegraphy.headerMedRoboto,
                    color = AeroTheme.colors.headerColor,
                    modifier = Modifier
                        .padding(start = AeroTheme.dimens.dp16)
                        .align(alignment = Alignment.CenterVertically)
                )
            }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = AeroTheme.dimens.dp16)
                .fillMaxWidth(),

            content = {

                Text(
                    text = "Включить темную тему",
                    modifier = Modifier.weight(weight = 1f)
                )

                Checkbox(
                    checked = settingsState.isDarkMode,
                    onCheckedChange = {
                        onSettingsChanged.invoke(
                            settingsState.copy(
                                isDarkMode = !settingsState.isDarkMode
                            )
                        )
                    }
                )
            }
        )
    }
}