package com.edaakyil.app.flags.ui.components

import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.navigation.HomeDestination
import com.edaakyil.app.flags.ui.navigation.InfoDestination
import com.edaakyil.app.flags.ui.navigation.NavigationBarDestination
import com.edaakyil.app.flags.ui.navigation.navigationBarDestinations
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun AppNavRail(
    allDestinations: List<NavigationBarDestination>,
    currentDestination: NavigationBarDestination,
    onTabSelected: (NavigationBarDestination) -> Unit, // Parameter may be String
    modifier: Modifier = Modifier
) {
    NavigationRail(
        header = {
            Icon(
                painter = painterResource(R.drawable.flag_circle),
                contentDescription = null
            )
        },
        modifier = modifier.widthIn(max = 80.dp)
    ) {
        HorizontalDivider()

        allDestinations.forEach {
            if (it == InfoDestination) {
                HorizontalDivider()
            }

            NavigationRailItem(
                selected = it.route == currentDestination.route,
                alwaysShowLabel = false,
                onClick = { onTabSelected(it) },
                label = { Text(stringResource(it.titleResId)) },
                icon = {
                    Icon(
                        painter = painterResource(if (it.route == currentDestination.route) it.filledIconRes else it.outlineIconRes),
                        contentDescription = stringResource(it.titleResId)
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun AppNavRailPreview() {
    FlagsTheme {
        AppNavRail(
            allDestinations = navigationBarDestinations,
            currentDestination = HomeDestination,
            onTabSelected = {}
        )
    }
}