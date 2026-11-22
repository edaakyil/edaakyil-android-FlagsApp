package com.edaakyil.app.flags.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.ui.MainScreenLayout
import com.edaakyil.app.flags.ui.details.DetailsScreen
import com.edaakyil.app.flags.ui.home.HomeScreen
import com.edaakyil.app.flags.ui.interests.InterestsScreen
import com.edaakyil.app.flags.ui.quiz.CapitalsQuizScreen
import com.edaakyil.app.flags.ui.quiz.FlagsQuizScreen
import com.edaakyil.app.flags.ui.quiz.QuizMenuScreen
import com.edaakyil.app.flags.ui.settings.SettingsScreen

@Composable
fun FlagsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    //val backStackEntry by navController.currentBackStackEntryAsState()
    //val currentRoute = backStackEntry?.destination?.route
    //val currentScreen = navigationBarDestinations.find { it.route == currentRoute } ?: HomeDestination

    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier,
    ) {
        composable(route = HomeDestination.route) {
            MainScreenLayout(
                currentDestination = HomeDestination,
                onNavigationItemSelected = { navController.navigateSingleTopTo(route = it.route) }
            ) {
                 HomeScreen(Modifier.fillMaxSize())
            }
        }

        composable(route = InterestsDestination.route) {
            MainScreenLayout(
                currentDestination = InterestsDestination,
                onNavigationItemSelected = { navController.navigateSingleTopTo(route = it.route) }
            ) {
                InterestsScreen(
                    onContinentClicked = { index -> navController.navigateToDetails(index) },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        composable(
            route = DetailsDestination.routeWithArgs,
            arguments = DetailsDestination.arguments,
            deepLinks = DetailsDestination.deepLinks
        ) { navBackStackEntry ->
            val continentIndex = navBackStackEntry.arguments?.getInt(DetailsDestination.continentTypeArg) ?: 0
            val continent = ContinentsData.continentsList[continentIndex]
            val countries = continent.countries.toList()

            DetailsScreen(
                continent = continent,
                countriesList = countries,
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = QuizMenuDestination.route) {
            MainScreenLayout(
                currentDestination = QuizMenuDestination,
                onNavigationItemSelected = { navController.navigateSingleTopTo(route = it.route) }
            ) {
                QuizMenuScreen(
                    onStartButtonClicked = { quiz, continent-> navController.navigateToQuiz(quiz, continent) },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        composable(
            route = QuizDestination.routeWithArgs,
            arguments = QuizDestination.arguments,
            deepLinks = QuizDestination.deepLinks
        ) { navBackStackEntry ->
            val quizTypeIndex = navBackStackEntry.arguments?.getInt(QuizDestination.quizTypeArg) ?: 0
            //val continentTypeIndex = navBackStackEntry.arguments?.getInt(QuizDestination.continentTypeArg) ?: 0

            when (quizTypeIndex) {
                0 -> FlagsQuizScreen(modifier = Modifier.fillMaxSize())
                else -> CapitalsQuizScreen(modifier = Modifier.fillMaxSize())
            }
        }

        composable(route = SettingsDestination.route) {
            SettingsScreen(Modifier.fillMaxSize())
        }
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    restoreState = true
    launchSingleTop = true
    popUpTo(
        this@navigateSingleTopTo.graph.findStartDestination().id
    ) {
        saveState = true
    }
}

private fun NavHostController.navigateToQuiz(quizTypeIndex: Int, continentIndex: Int) {
    this.navigate("${QuizDestination.route}/$quizTypeIndex/$continentIndex") {
        launchSingleTop = true
        popUpTo(QuizMenuDestination.route) {
            inclusive = false
        }
    }
}

private fun NavHostController.navigateToDetails(continentIndex: Int) {
    this.navigate("${DetailsDestination.route}/$continentIndex") {
        launchSingleTop = true
        popUpTo(InterestsDestination.route) { inclusive = false }
    }
}