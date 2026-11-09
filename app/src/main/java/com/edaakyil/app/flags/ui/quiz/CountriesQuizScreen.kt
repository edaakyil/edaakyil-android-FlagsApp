package com.edaakyil.app.flags.ui.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun CountriesQuizScreen(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column() { }
    }
}

@Preview
@Composable
private fun CountriesQuizScreenPreview() {
    FlagsTheme {
        CountriesQuizScreen()
    }
}