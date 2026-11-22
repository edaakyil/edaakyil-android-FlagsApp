package com.edaakyil.app.flags.ui.interests

import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.FlexAlignContent
import androidx.compose.foundation.layout.FlexAlignItems
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlexDirection
import androidx.compose.foundation.layout.FlexJustifyContent
import androidx.compose.foundation.layout.FlexWrap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.ui.components.ContinentCardElement
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@OptIn(ExperimentalGridApi::class, ExperimentalFlexBoxApi::class)
@Composable
fun InterestsScreen(
    onContinentClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    FlexBox(
        config = {
            gap(16.dp)
            wrap(FlexWrap.Wrap)
            direction(FlexDirection.Row)
            alignItems(FlexAlignItems.Center)
            alignContent(FlexAlignContent.Center)
            justifyContent(FlexJustifyContent.Center)
        },
        modifier = modifier.fillMaxSize()
    ) {
        ContinentsData.continentsList.forEachIndexed { index, continent ->
            var startedState by rememberSaveable { mutableStateOf(false) }

            ContinentCardElement(
                continent = continent,
                isStarted = startedState,
                onCardClicked = { onContinentClicked(index) },
                onStarIconClicked = { startedState = !startedState }
            )
        }
    }
}

/*
@OptIn(ExperimentalGridApi::class)
@Composable
fun InterestsScreen(modifier: Modifier = Modifier) {
    Grid(
        config = {
            gap(all = 8.dp)
            flow = GridFlow.Row
            //column(1f)
            repeat(2) { column(1.fr) }
            //repeat(2) { column(100.dp) }
            //repeat(3) { row(100.dp) }
        },
        modifier = modifier.fillMaxSize()
    ) {
        ContinentsData.continentsList.forEach {
            var startedState by rememberSaveable { mutableStateOf(false) }

            ContinentCardElement(
                continent = it,
                isStarted = startedState,
                onStarIconClicked = { startedState = !startedState }
            )
        }
    }
}
*/

@Preview(device = PIXEL_XL)
@Composable
private fun SongScreenPreview() {
    FlagsTheme {
        InterestsScreen({})
    }
}