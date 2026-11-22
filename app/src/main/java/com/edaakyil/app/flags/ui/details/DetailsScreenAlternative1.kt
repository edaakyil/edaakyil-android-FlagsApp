package com.edaakyil.app.flags.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices.PIXEL_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.CountriesData
import com.edaakyil.app.flags.model.Country
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun DetailsScreenAlternative1(
    countriesList: Set<Country>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(countriesList.toList()) { country ->
            CountryDetailsCard(country, Modifier.fillMaxHeight())
        }
    }
}

@Composable
private fun CountryDetailsCard(
    country: Country,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(country.flagResId),
                contentDescription = country.name,
                modifier = Modifier.size(56.dp)
            )

            Text(
                text = country.name
            )

            Text(
                text = stringResource(R.string.capital, country.capital)
            )
        }
    }
}

@Preview(device = PIXEL_XL)
@Composable
private fun DetailsScreenPreview() {
    FlagsTheme {
        DetailsScreenAlternative1(countriesList = CountriesData.southAmericaCountries)
    }
}