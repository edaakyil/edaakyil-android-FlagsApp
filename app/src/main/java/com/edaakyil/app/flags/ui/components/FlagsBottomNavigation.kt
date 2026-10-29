package com.edaakyil.app.flags.ui.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
fun FlagsBottomNavigation(
    currentScreen: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = currentScreen == MainDestination.HOME_ROUTE,
            onClick = { onTabSelected(MainDestination.HOME_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home_filled),
                    contentDescription = stringResource(R.string.home_title)
                )
            },
            label = { Text(stringResource(R.string.home_title)) }
        )

        NavigationBarItem(
            selected = currentScreen == MainDestination.INTERESTS_ROUTE,
            onClick = { onTabSelected(MainDestination.INTERESTS_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.list_alt_filled),
                    contentDescription = stringResource(R.string.interests_title)
                )
            },
            label = { Text(stringResource(R.string.interests_title)) }
        )

        NavigationBarItem(
            selected = currentScreen == MainDestination.QUIZ_ROUTE,
            onClick = { onTabSelected(MainDestination.QUIZ_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.quiz),
                    contentDescription = stringResource(R.string.quiz_title)
                )
            },
            label = { Text(stringResource(R.string.quiz_title)) }
        )
    }
}

@Preview
@Composable
private fun FlagsBottomNavigationPreview() {
    FlagsTheme {
        FlagsBottomNavigation("home", {})
    }
}