package com.edaakyil.app.flags.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.navigation.HomeDestination
import com.edaakyil.app.flags.ui.navigation.NavigationBarDestination
import com.edaakyil.app.flags.ui.navigation.navigationBottomBarDestinations
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun FlagsBottomNavigation(
    allBarDestinations: List<NavigationBarDestination>,
    currentDestination: NavigationBarDestination,
    onTabSelected: (NavigationBarDestination) -> Unit, // Parameter may be String
    modifier: Modifier = Modifier
) {
    // It may be BottomNavigation build-in composable function
    NavigationBar(modifier = modifier) {
        allBarDestinations.forEach {
            val selected = it.route == currentDestination.route

            // It may be BottomNavigationItem build-in composable function
            NavigationBarItem(
                selected = selected,
                onClick = { onTabSelected(it) },
                icon = {
                    Icon(
                        painter = painterResource(if (selected) it.filledIconRes else it.outlineIconRes),
                        contentDescription = stringResource(it.titleResId)
                    )
                },
                label = { Text(stringResource(it.titleResId)) }
            )
        }
    }
}

@Preview
@Composable
private fun FlagsBottomNavigationPreview() {
    FlagsTheme {
        FlagsBottomNavigation(
            allBarDestinations = navigationBottomBarDestinations,
            currentDestination = HomeDestination,
            onTabSelected = {}
        )
    }
}