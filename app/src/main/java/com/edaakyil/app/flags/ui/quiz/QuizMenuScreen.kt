package com.edaakyil.app.flags.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.theme.FlagsTheme

private val quizList = listOf("Countries", "Flags")
private val quizSubTitlesList = listOf("North America", "South America", "Europe", "Asia", "Africa", "Australia", "Antarctica", "Mixed")

@Composable
fun QuizMenuScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(top = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var expandedCardId by rememberSaveable { mutableStateOf<Int?>(null) }

        Text(
            text = stringResource(R.string.quiz_menu_title),
            style = MaterialTheme.typography.headlineLarge,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        quizList.forEachIndexed { index, item ->
            val isExpanded = expandedCardId == index

            QuizMenuCard(
                quizTitle = item,
                subtitles = quizSubTitlesList,
                isCardClicked = isExpanded,
                onCardClicked = { expandedCardId = index },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun QuizMenuCard(
    quizTitle: String,
    subtitles: List<String>,
    isCardClicked: Boolean,
    onCardClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ElevatedCard(
            onClick = onCardClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = quizTitle,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }

        if (isCardClicked) {
            subtitles.forEachIndexed { index, item ->
                Text(item)

                if (index < subtitles.lastIndex) {
                    HorizontalDivider(
                        color = Color(0xFFD0C6D2),
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun QuizMenuScreenPreview() {
    FlagsTheme {
        QuizMenuScreen()
    }
}