package com.edaakyil.app.flags.ui.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.ui.components.ContinentCardElement
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun ContinentsCardsRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.width(0.dp))

        ContinentsData.continentsList.forEach {
            var startedState by rememberSaveable { mutableStateOf(false) }

            ContinentCardElement(
                continent = it,
                isStarted = startedState,
                onStarIconClicked = { startedState = !startedState }
            )
        }

        Spacer(modifier = Modifier.width(0.dp))
    }
}

@Preview
@Composable
private fun ContinentsCardsRowPreview() {
    FlagsTheme {
        ContinentsCardsRow()
    }
}