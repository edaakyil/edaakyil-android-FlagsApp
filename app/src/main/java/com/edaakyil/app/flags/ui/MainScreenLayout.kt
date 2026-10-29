package com.edaakyil.app.flags.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.components.AppNavRail
import com.edaakyil.app.flags.ui.components.FlagsBottomNavigation
import com.edaakyil.app.flags.ui.components.FlagsTopBar
import com.edaakyil.app.flags.ui.navigation.MainDestination
import com.edaakyil.app.flags.ui.theme.FlagsTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreenLayout(
    currentScreen: String,
    onNavigationItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                NavigationDrawerItem(
                    selected = currentScreen == MainDestination.HOME_ROUTE,
                    label = { Text(stringResource(R.string.home_title)) },
                    onClick = { scope.launch { drawerState.close() }; onNavigationItemSelected(MainDestination.HOME_ROUTE) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.home_filled),
                            contentDescription = stringResource(R.string.home_title)
                        )
                    }
                )

                NavigationDrawerItem(
                    selected = currentScreen == MainDestination.INTERESTS_ROUTE,
                    label = { Text(stringResource(R.string.interests_title)) },
                    onClick = { scope.launch { drawerState.close() }; onNavigationItemSelected(MainDestination.INTERESTS_ROUTE) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.list_alt_filled),
                            contentDescription = stringResource(R.string.interests_title)
                        )
                    }
                )

                NavigationDrawerItem(
                    selected = currentScreen == MainDestination.QUIZ_ROUTE,
                    label = { Text(stringResource(R.string.quiz_title)) },
                    onClick = { scope.launch { drawerState.close() }; onNavigationItemSelected(MainDestination.QUIZ_ROUTE) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.quiz),
                            contentDescription = stringResource(R.string.quiz_title)
                        )
                    }
                )

                NavigationDrawerItem(
                    selected = currentScreen == MainDestination.SETTINGS_ROUTE,
                    label = { Text(stringResource(R.string.settings_title)) },
                    onClick = { scope.launch { drawerState.close() }; onNavigationItemSelected(MainDestination.SETTINGS_ROUTE) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.settings_filled),
                            contentDescription = stringResource(R.string.settings_title)
                        )
                    }
                )
            }
        }
    ) {
        Scaffold(
            modifier = modifier,
            topBar = { FlagsTopBar(onClick = { scope.launch { drawerState.open() } }) },
            bottomBar =  { FlagsBottomNavigation(currentScreen, onNavigationItemSelected) }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}

@Composable
fun DemoScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text("DemoContentScreen")
    }
}

@Preview
@Composable
private fun MainScreenLayoutPreview() {
    FlagsTheme {
        MainScreenLayout(
            currentScreen = "home",
            onNavigationItemSelected = {},
            modifier = Modifier.fillMaxSize(),
            content = { DemoScreen(Modifier.padding(it)) }
        )
    }
}