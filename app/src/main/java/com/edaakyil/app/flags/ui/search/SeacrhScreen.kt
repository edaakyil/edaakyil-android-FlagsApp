package com.edaakyil.app.flags.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search Screen")
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    FlagsTheme {
        SearchScreen()
    }
}