package com.edaakyil.app.flags.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun DetailsScreenAlternative2(
    countriesList: Set<Country>,
    modifier: Modifier = Modifier
) {
    val countries = countriesList.toList()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        //verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(countries) { index, country ->
            CountryDetailsCard(country, Modifier.fillMaxHeight())

            if (index < countries.lastIndex) {
                HorizontalDivider(
                    color = Color(0xFFD0C6D2),
                    thickness = 1.dp
                )
            }
        }
    }
}

@Composable
private fun CountryDetailsCard(
    country: Country,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(country.flagResId),
            contentDescription = country.name,
            modifier = Modifier.size(80.dp)
        )

        Spacer(Modifier.width(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = country.name,
                style = MaterialTheme.typography.headlineSmall,
                //fontWeight = FontWeight.SemiBold,
                color = Color(0xFF242127)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.capital, country.capital),
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF514A55)
            )
        }
    }
}

@Preview(device = PIXEL_XL)
@Composable
private fun DetailsScreenPreview() {
    FlagsTheme {
        DetailsScreenAlternative2(countriesList = CountriesData.southAmericaCountries)
    }
}