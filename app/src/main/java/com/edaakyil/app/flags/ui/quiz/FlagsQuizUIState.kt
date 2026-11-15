package com.edaakyil.app.flags.ui.quiz

import com.edaakyil.app.flags.model.Country

data class FlagsQuizUIState(
    val currentCountry: Country,
    val currentOptions: Set<String> = emptySet(),
    val currentFlagCount: Int = 1,
    val score: Int = 0,
    val isGuessWrong: Boolean = false,
    val isGameOver: Boolean = false
)