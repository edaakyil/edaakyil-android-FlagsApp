package com.edaakyil.app.flags.ui.quiz

import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.data.CountriesData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.model.Country

data class FlagsQuizUIState(
    val continent: Continent = ContinentsData.continentsList.first(),
    val currentCountry: Country = CountriesData.southAmericaCountries.first(),
    val currentOptions: Set<String> = emptySet(),
    val currentFlagCount: Int = 1,
    val score: Int = 0,
    val isGuessWrong: Boolean = false,
    val isGameOver: Boolean = false
)