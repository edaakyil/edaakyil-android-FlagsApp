package com.edaakyil.app.flags.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edaakyil.app.flags.ui.MainScreenLayout
import com.edaakyil.app.flags.ui.home.HomeScreen
import com.edaakyil.app.flags.ui.interests.SongScreen
import com.edaakyil.app.flags.ui.quiz.CapitalsQuizScreen
import com.edaakyil.app.flags.ui.quiz.FlagsQuizScreen
import com.edaakyil.app.flags.ui.quiz.QuizMenuScreen2
import com.edaakyil.app.flags.ui.settings.SettingsScreen

@Composable
fun FlagsNavHost(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
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
                SongScreen(Modifier.fillMaxSize())
            }
        }

        composable(route = QuizMenuDestination.route) {
            MainScreenLayout(
                currentDestination = QuizMenuDestination,
                onNavigationItemSelected = { navController.navigateSingleTopTo(route = it.route) }
            ) {
                QuizMenuScreen2(
                    onStartButtonClicked = { index -> navController.navigateToQuiz(index) },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        composable(
            route = QuizDestination.routeWithArgs,
            arguments = QuizDestination.arguments,
            deepLinks = QuizDestination.deepLinks
        ) { navBackStackEntry ->
            val quizTypeIndexArg = navBackStackEntry.arguments?.getInt(QuizDestination.quizTypeIndexArg)
            //val continentType = navBackStackEntry.arguments?.getString(QuizDestination.continentTypeArg)

            /*when (quizType) {
                "flags" -> FlagsQuizScreen(continentType = continentType)
                "capitals" -> CapitalsQuizScreen(continentType = continentType)
            }*/

            when (quizTypeIndexArg) {
                0 -> FlagsQuizScreen()
                else -> CapitalsQuizScreen()
            }
        }

//        composable(route = MainDestination.QUIZ_ROUTE) {
//            MainScreenLayout(
//                currentScreen = MainDestination.QUIZ_ROUTE,
//                onNavigationItemSelected = { navController.navigate(route = it) }
//            ) {
//                QuizMenuScreen(Modifier.fillMaxSize())
//            }
//        }

        composable(route = SettingsDestination.route) {
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

private fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    restoreState = true
    launchSingleTop = true
    popUpTo(
        this@navigateSingleTopTo.graph.findStartDestination().id
    ) {
        saveState = true
    }
}

private fun NavHostController.navigateToQuiz(quizTypeIndex: Int) {
    this.navigateSingleTopTo("${QuizDestination.route}/$quizTypeIndex")
}