package com.edaakyil.app.flags.ui.components

import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.navigation.MainDestination
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun AppNavRail(
    currentScreen: String,
    onTabSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        header = {
            Icon(
                painter = painterResource(R.drawable.flag_circle),
                contentDescription = null
            )
        },
        modifier = modifier
    ) {
        //HorizontalDivider()
        /*
        (1..5).toList().forEach { NavigationRailItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home_filled),
                    contentDescription = stringResource(R.string.home_title)
                )
            },
            label = { Text(stringResource(R.string.home_title)) },
            alwaysShowLabel = false
        ) }*/

        NavigationRailItem(
            selected = currentScreen == MainDestination.HOME_ROUTE,
            onClick = onTabSelected,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home_filled),
                    contentDescription = stringResource(R.string.home_title)
                )
            },
            label = { Text(stringResource(R.string.home_title)) },
            alwaysShowLabel = false
        )

        NavigationRailItem(
            selected = currentScreen == MainDestination.INTERESTS_ROUTE,
            onClick = onTabSelected,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.list_alt_filled),
                    contentDescription = stringResource(R.string.interests_title)
                )
            },
            label = { Text(stringResource(R.string.interests_title)) },
            alwaysShowLabel = false
        )

        NavigationRailItem(
            selected = currentScreen == MainDestination.SETTINGS_ROUTE,
            onClick = onTabSelected,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.settings_filled),
                    contentDescription = stringResource(R.string.settings_title)
                )
            },
            label = { Text(stringResource(R.string.interests_title)) },
            alwaysShowLabel = false
        )

        NavigationRailItem(
            selected = currentScreen == MainDestination.QUIZ_ROUTE,
            onClick = onTabSelected,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.quiz),
                    contentDescription = stringResource(R.string.quiz_title)
                )
            },
            label = { Text(stringResource(R.string.quiz_title)) },
            alwaysShowLabel = false
        )
    }
}

@Preview
@Composable
fun AppNavRailPreview() {
    FlagsTheme {
        AppNavRail("home", {})
    }
}