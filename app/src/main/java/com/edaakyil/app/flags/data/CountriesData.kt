package com.edaakyil.app.flags.data

import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.model.Country

object CountriesData {
    val southAmericaCountries: Set<Country> = setOf(
        Country(id = 1, name = "Argentina", capital = "Buenos Aires", flagResId = R.drawable.flag_of_argentina_svg),
        Country(id = 2, name = "Bolivia", capital = "Sucre", flagResId = R.drawable.flag_of_bolivia_svg),
        Country(id = 3, name = "Brazil", capital = "Brasília", flagResId = R.drawable.flag_of_brazil_svg),
        Country(id = 4, name = "Chile", capital = "Santiago", flagResId = R.drawable.flag_of_chile_svg),
        Country(id = 5, name = "Colombia", capital = "Bogotá", flagResId = R.drawable.flag_of_colombia_svg),
        Country(id = 6, name = "Ecuador", capital = "Quito[", flagResId = R.drawable.flag_of_ecuador_svg),
        Country(id = 7, name = "Guyana", capital = "Georgetown", flagResId = R.drawable.flag_of_guyana_svg),
        Country(id = 8, name = "Paraguay", capital = "Asunción", flagResId = R.drawable.flag_of_paraguay_svg),
        Country(id = 9, name = "Peru", capital = "Lima", flagResId = R.drawable.flag_of_peru_svg),
        Country(id = 10, name = "Suriname", capital = "Paramaribo", flagResId = R.drawable.flag_of_suriname_svg),
        Country(id = 11, name = "Uruguay", capital = "Montevideo", flagResId = R.drawable.flag_of_uruguay_svg),
        Country(id = 12, name = "Venezuela", capital = "Caracas", flagResId = R.drawable.flag_of_venezuela_svg),
    )

    //fun getCountryFromSouthAmerica(countryName: String): Country = southAmericaCountries.find { it.name == countryName } ?: southAmericaCountries[0]
}

val africanCountries = listOf(
    "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso",
    "Burundi", "Cameroon", "Cape Verde", "Central African Republic", "Chad",
    "Comoros", "Congo", "Democratic Republic of the Congo", "Djibouti", "Egypt",
    "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia", "Gabon",
    "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Ivory Coast",
    "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar",
    "Malawi", "Mali", "Mauritania", "Mauritius", "Morocco",
    "Mozambique", "Namibia", "Niger", "Nigeria", "Rwanda",
    "São Tomé and Príncipe", "Senegal", "Seychelles", "Sierra Leone", "Somalia",
    "South Africa", "South Sudan", "Sudan", "Tanzania", "Togo",
    "Tunisia", "Uganda", "Zambia", "Zimbabwe"
)