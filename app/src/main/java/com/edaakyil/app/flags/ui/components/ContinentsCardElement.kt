package com.edaakyil.app.flags.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun ContinentCardElement(
    //title: String,
    //countries: Int,
    continent: Continent,
    isStarted: Boolean,
    onStarIconClicked: () -> Unit,
    modifier: Modifier = Modifier,
    onCardClicked: () -> Unit = {}
) {
    ElevatedCard(
        onClick = onCardClicked,
        modifier = modifier.size(width = 180.dp, height = 100.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = continent.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f)
                )

                StarButton(
                    isStarted = isStarted,
                    onStarIconClicked = onStarIconClicked
                )
            }

            Text(
                text = stringResource(R.string.number_of_countries, continent.countries.size)
            )
        }
    }
}

@Preview
@Composable
private fun ContinentCardElementPreview() {
    FlagsTheme {
        ContinentCardElement(
            //title = "Africa",
            //countries = 54,
            continent = ContinentsData.getContinent("North America"),
            isStarted = false,
            onCardClicked = {},
            onStarIconClicked = {}
        )
    }
}