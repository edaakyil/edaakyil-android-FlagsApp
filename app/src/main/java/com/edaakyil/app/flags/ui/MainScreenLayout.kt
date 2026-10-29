package com.edaakyil.app.flags.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.components.AppNavRail
import com.edaakyil.app.flags.ui.components.FlagsBottomNavigation
import com.edaakyil.app.flags.ui.components.FlagsTopBar
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun MainScreenLayout(
    currentScreen: String,
    onNavigationItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var isNavigationRailVisible by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = { FlagsTopBar({ isNavigationRailVisible = !isNavigationRailVisible }) },
        bottomBar =  { FlagsBottomNavigation(currentScreen, onNavigationItemSelected) }
    ) { innerPadding ->
        Row(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            if (isNavigationRailVisible) {
                AnimatedVisibility(
                    visible = isNavigationRailVisible,
                    enter = slideInHorizontally(initialOffsetX = { -it }),
                    exit = slideOutHorizontally(targetOffsetX = { -it })
                ) {
                    AppNavRail(
                        currentScreen = currentScreen,
                        onTabSelected = onNavigationItemSelected
                    )
                }
            }

            content()
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
            content = { DemoScreen() }
        )
    }
}