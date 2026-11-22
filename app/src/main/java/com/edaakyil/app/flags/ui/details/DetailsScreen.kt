package com.edaakyil.app.flags.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Devices.PIXEL_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.data.CountriesData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.model.Country
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun DetailsScreen(
    continent: Continent,
    countriesList: List<Country>,
    modifier: Modifier = Modifier
) {
    var openDetailsDialog by rememberSaveable { mutableStateOf(false) }
    var selectedCountryIndex by rememberSaveable { mutableIntStateOf(0) }
    
    Text(continent.name)

    DetailsList(
        countriesList = countriesList,
        onImageClicked = { index ->
            selectedCountryIndex = index
            openDetailsDialog = !openDetailsDialog
        },
        modifier = modifier
    )

    if (openDetailsDialog) {
        DetailsDialogElement(
            country = countriesList[selectedCountryIndex],
            onDismissRequest = { openDetailsDialog = false }
        )
    }
}

@Composable
fun DetailsList(
    countriesList: List<Country>,
    onImageClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        //verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(countriesList) { index, country ->
            CountryDetailsCard(
                country = country,
                onImageClicked = { onImageClicked(index) },
                modifier = Modifier.fillMaxHeight()
            )

            if (index < countriesList.lastIndex) {
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
    onImageClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(country.flagResId),
            contentDescription = country.name,
            modifier = Modifier
                .size(80.dp)
                .clickable(
                    role = Role.Image,
                    onClick = onImageClicked
                )
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
    val countries = CountriesData.southAmericaCountries.toList()

    FlagsTheme {
        DetailsScreen(continent = ContinentsData.continentsList[2], countriesList = countries)
    }
}