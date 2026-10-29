package com.edaakyil.app.flags.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.components.FlagsBottomNavigation
import com.edaakyil.app.flags.ui.components.FlagsTopBar
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun MainScreenLayout(
    currentScreen: String,
    onMenuSelected: () -> Unit,
    onBottomBarItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { FlagsTopBar(onMenuSelected) },
        bottomBar =  { FlagsBottomNavigation(currentScreen, onBottomBarItemSelected) }
    ) { innerPadding ->
        content(innerPadding)
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
            onMenuSelected = {},
            onBottomBarItemSelected = {},
            modifier = Modifier.fillMaxSize(),
            content = { innerPadding ->
                DemoScreen(modifier = Modifier.padding(innerPadding))
            }
        )
    }
}