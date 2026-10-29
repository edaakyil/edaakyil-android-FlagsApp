package com.edaakyil.app.flags.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edaakyil.app.flags.ui.MainScreenLayout
import com.edaakyil.app.flags.ui.home.HomeScreen
import com.edaakyil.app.flags.ui.interests.InterestsScreen
import com.edaakyil.app.flags.ui.quiz.QuizScreen

@Composable
fun FlagsNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    var isNavigationRailVisible by rememberSaveable { mutableStateOf(false) }

    NavHost(
        navController = navController,
        startDestination = MainDestination.HOME_ROUTE,
        modifier = modifier,
    ) {
        composable(route = MainDestination.HOME_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.HOME_ROUTE,
                onMenuSelected = { isNavigationRailVisible = !isNavigationRailVisible },
                onBottomBarItemSelected = { navController.navigate(route = it) }
            ) {
                 HomeScreen()
            }
        }

        composable(route = MainDestination.INTERESTS_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.INTERESTS_ROUTE,
                onMenuSelected = { isNavigationRailVisible = !isNavigationRailVisible },
                onBottomBarItemSelected = { navController.navigate(route = it) }
            ) {
                InterestsScreen()
            }
        }

        composable(route = MainDestination.QUIZ_ROUTE) {
            MainScreenLayout(
                currentScreen = MainDestination.QUIZ_ROUTE,
                onMenuSelected = { isNavigationRailVisible = !isNavigationRailVisible },
                onBottomBarItemSelected = { navController.navigate(route = it) }
            ) {
                QuizScreen()
            }
        }
    }
}