package com.nassdk.profile.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.nassdk.profile.R
import com.nassdk.profile.domain.entity.SettingsBundle
import com.nassdk.ui.kit.Toolbar
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

        Toolbar(
            title = stringResource(id = R.string.settings_title),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AeroTheme.colors.secondaryBackground),
            backButtonListener = { navController.popBackStack() }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = AeroTheme.dimens.dp16)
                .fillMaxWidth(),

            content = {

                Text(
                    text = stringResource(id = R.string.settings_turn_dark_theme_title),
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