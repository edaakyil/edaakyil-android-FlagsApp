package com.edaakyil.app.flags.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.edaakyil.app.flags.ui.navigation.FlagsNavHost
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun FlagsApp() {
    FlagsTheme {
        val navController: NavHostController = rememberNavController()
        //val currentBackStack by navController.currentBackStackEntryAsState()
        //val currentDestination = currentBackStack?.destination?.route

        FlagsNavHost(navController = navController)
    }
}

@Preview
@Composable
private fun FlagsAppPreview() {
    FlagsTheme {
        FlagsApp()
    }
}

