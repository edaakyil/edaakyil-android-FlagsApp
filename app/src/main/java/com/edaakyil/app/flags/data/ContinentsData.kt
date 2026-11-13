package com.edaakyil.app.flags.data

import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.model.Continent

object ContinentsData {
    val continentsList = listOf(
        Continent(id = 1, name = "North America", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 2, name = "South America", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 3, name = "Europe", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 4, name = "Asia", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 5, name = "Africa", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 6, name = "Australia", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries),
        Continent(id = 7, name = "Antarctica", imageResId = R.drawable.africa_continent, countries = CountriesData.southAmericaCountries)
    )

    fun getContinent(continentName: String): Continent = continentsList.find { it.name == continentName } ?: continentsList[0]
}


/*
val continentsList = listOf(
    "North America" to 23,
    "South America" to 12,
    "Europe" to 50,
    "Asia" to 54,
    "Africa" to 54,
    "Australia" to 2,
    "Antarctica" to 7
)
 */

//private val quizSubTitlesList = listOf("North America", "South America", "Europe", "Asia", "Africa", "Australia", "Antarctica", "Mixed")
