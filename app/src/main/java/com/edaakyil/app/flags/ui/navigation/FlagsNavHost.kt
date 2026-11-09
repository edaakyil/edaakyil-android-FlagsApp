package com.edaakyil.app.flags.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edaakyil.app.flags.ui.MainScreenLayout
import com.edaakyil.app.flags.ui.home.HomeScreen
import com.edaakyil.app.flags.ui.interests.SongScreen
import com.edaakyil.app.flags.ui.quiz.QuizMenuScreen
import com.edaakyil.app.flags.ui.settings.SettingsScreen

@Composable
fun FlagsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {


    NavHost(
        navController = navController,
        startDestination = MainDestination.HOME_ROUTE,
        modifier = modifier,
    ) {
        composable(route = MainDestination.HOME_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.HOME_ROUTE,
                onNavigationItemSelected = { navController.navigate(route = it) }
            ) {
                 HomeScreen(Modifier.padding(it).fillMaxSize())
            }
        }

        composable(route = MainDestination.INTERESTS_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.INTERESTS_ROUTE,
                onNavigationItemSelected = { navController.navigate(route = it) }
            ) {
                SongScreen(Modifier.padding(it).fillMaxSize())
            }
        }

        composable(route = MainDestination.QUIZ_MENU_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.QUIZ_MENU_ROUTE,
                onNavigationItemSelected = { navController.navigate(route = it) }
            ) {
                QuizMenuScreen(Modifier.padding(it).fillMaxSize())
            }
        }

        composable(route = MainDestination.QUIZ_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.QUIZ_ROUTE,
                onNavigationItemSelected = { navController.navigate(route = it) }
            ) {
                QuizMenuScreen(Modifier.padding(it).fillMaxSize())
            }
        }

        composable(route = MainDestination.SETTINGS_ROUTE) {
            /*MainScreenLayout(
                currentScreen = MainDestination.SETTINGS_ROUTE,
                onNavigationItemSelected = { navController.navigate(route = it) }
            ) {
                SettingsScreen(Modifier.padding(it).fillMaxSize())
            }*/

            SettingsScreen(Modifier.fillMaxSize())
        }
    }
}