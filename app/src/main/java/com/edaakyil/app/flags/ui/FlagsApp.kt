package com.edaakyil.app.flags.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.edaakyil.app.flags.ui.navigation.FlagsNavHost
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun FlagsApp() {
    FlagsTheme {
        //val navController = rememberNavController()
        //val currentBackStack by navController.currentBackStackEntryAsState()
        //val currentDestination = currentBackStack?.destination?.route

        FlagsNavHost()
    }
}

@Preview
@Composable
private fun FlagsAppPreview() {
    FlagsTheme {
        FlagsApp()
    }
}

