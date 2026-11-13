package com.edaakyil.app.flags.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.edaakyil.app.flags.R

//object MainDestination {
//    const val HOME_ROUTE = "home"
//    const val QUIZ_ROUTE = "quiz"
//    const val QUIZ_MENU_ROUTE = "quizMenu"
//    const val FLAGS_QUIZ_ROUTE = "flagsQuiz"
//    const val CAPITALS_QUIZ_ROUTE = "capitalsQuiz"
//    const val INTERESTS_ROUTE = "interests"
//    const val DETAILS_ROUTE = "details"
//    const val SETTINGS_ROUTE = "settings"
//    const val ABOUT_ME_ROUTE = "aboutMe"
//}

val navigationBottomBarDestinations = listOf(
    HomeDestination,
    InterestsDestination,
    QuizMenuDestination
)
val navigationBarDestinations = navigationBottomBarDestinations + listOf(
    SettingsDestination,
    InfoDestination
)

interface NavigationDestination {
    val route: String
    val titleResId: Int
}

sealed interface NavigationBarDestination : NavigationDestination {
    val outlineIconRes: Int
    val filledIconRes: Int
}

data object HomeDestination : NavigationBarDestination {
    override val route = "home"
    override val titleResId = R.string.home_title
    override val outlineIconRes = R.drawable.home
    override val filledIconRes = R.drawable.home_filled
}

data object InterestsDestination : NavigationBarDestination {
    override val route = "interests"
    override val titleResId = R.string.interests_title
    override val outlineIconRes = R.drawable.list_alt
    override val filledIconRes = R.drawable.list_alt_filled
}

data object SettingsDestination : NavigationBarDestination {
    override val route = "settings"
    override val titleResId = R.string.settings_title
    override val outlineIconRes = R.drawable.settings
    override val filledIconRes = R.drawable.settings_filled
}

data object InfoDestination : NavigationBarDestination {
    override val route = "aboutMe"
    override val titleResId = R.string.info_title
    override val outlineIconRes = R.drawable.info
    override val filledIconRes = R.drawable.info_filled
}

data object QuizMenuDestination : NavigationBarDestination {
    override val route = "quizMenu"
    override val titleResId = R.string.quiz_menu_title
    override val outlineIconRes = R.drawable.quiz
    override val filledIconRes = R.drawable.quiz_filled
}

data object QuizDestination : NavigationDestination {
    override val route = "quiz"
    override val titleResId = R.string.quiz_title
    const val quizTypeIndexArg = "quiz_type"
    val routeWithArgs = "$route/{$quizTypeIndexArg}"
    val arguments = listOf(
        navArgument(quizTypeIndexArg) { type = NavType.IntType },
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "flags://$route/{$quizTypeIndexArg}" }
    )

    /*const val continentTypeArg = "continent_type_arg"
    val routeWithArgs = "$route/{$quizTypeArg}/{$continentTypeArg}"
    val arguments = listOf(
        navArgument(quizTypeArg) { type = NavType.StringType},
        navArgument(continentTypeArg) { type = NavType.StringType}
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "flags://$route/{$quizTypeArg}/{$continentTypeArg}" }
    )*/
}

data object FlagsQuizDestination : NavigationDestination {
    override val route: String = "flagsQuiz"
    override val titleResId: Int = R.string.flags_quiz_title
}