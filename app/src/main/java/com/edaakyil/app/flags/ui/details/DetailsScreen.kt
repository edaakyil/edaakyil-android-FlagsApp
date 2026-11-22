package com.edaakyil.app.flags.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.CountriesData
import com.edaakyil.app.flags.model.Country
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun DetailsScreen(
    country: Country,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(country.flagResId),
                contentDescription = country.name
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

@Preview
@Composable
private fun DetailsScreenPreview() {
    FlagsTheme {
        DetailsScreen(country = CountriesData.southAmericaCountries.first())
    }
}