package com.edaakyil.app.flags.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("HomeScreen")
        HorizontalDivider()
        Text("Your Score & Progress")
        HorizontalDivider()
        Text("List of Continents")
        ContinentsCardsRow()
        HorizontalDivider()
        Text("List of Countries")
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FlagsTheme {
        HomeScreen()
    }
}