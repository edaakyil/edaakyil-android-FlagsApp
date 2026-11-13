package com.edaakyil.app.flags.ui.quiz

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.components.QuizButtonGroup
import com.edaakyil.app.flags.ui.components.StarButton
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun FlagsQuizScreen(
    continentIndex: Int,
    modifier: Modifier = Modifier,
    viewModel: FlagsQuizViewModel = viewModel()
) {
    viewModel.setContinent(continentIndex)
    val uiState by viewModel.uiState.collectAsState()
    //val options = CountriesData.southAmericaCountries.take(4).map { it.name }
    //val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(options[0]) }

    Column(
        modifier = modifier
            .statusBarsPadding()
            .safeDrawingPadding()
            .padding(horizontal = 24.dp)
    ) {
        Text("FlagsQuizScreen - continentType: ${uiState.continent.name}")

        Spacer(Modifier.height(48.dp))

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.game_score, uiState.score),
                    style = MaterialTheme.typography.titleLarge
                )

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.exit),
                        contentDescription = stringResource(R.string.exit)
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            QuestionCard(
                flagCount = uiState.currentFlagCount,
                isStarted = false,
                flagResId = uiState.currentCountry.flagResId,
                onStarIconClicked = {},
            )

            Spacer(Modifier.height(32.dp))

            OptionsGroup(
                options = uiState.currentOptions,
                selectedOption = viewModel.userGuess,
                onOptionSelected = { viewModel.updateUserGuess(it) },
                modifier = Modifier.align(Alignment.Start)
            )
        }

        QuizButtonGroup(
            onSkipButtonClicked = { viewModel.skipFlag() },
            onSubmitButtonClicked = { viewModel.checkUserGuess() },
            modifier = Modifier.padding(bottom = 32.dp)
        )
    }
}

@Composable
private fun QuestionCard(
    flagCount: Int,
    isStarted: Boolean,
    @DrawableRes flagResId: Int,
    onStarIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StarButton(
                    isStarted = isStarted,
                    onStarIconClicked = onStarIconClicked,
                    modifier = Modifier.size(32.dp)
                )

                Text(
                    text = stringResource(R.string.game_count, flagCount),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.surfaceTint)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        //.align(Alignment.End)
                )
            }

            Image(
                painter = painterResource(flagResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp)
            )

            Text(
                text = "Which country does this flag belong to?",
                fontSize = 17.sp
            )
        }
    }
}

@Composable
private fun OptionsGroup(
    options: Set<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val labels = listOf('A', 'B', 'C', 'D')
    //val op = listOf('A', 'B', 'C', 'D').zip(options).toMap()

    Column(modifier = modifier.selectableGroup()) {
        options.forEachIndexed { index, option ->
            OptionButton(
                text = option,
                label = "${labels[index]}.",
                isSelected = option == selectedOption,
                onOptionSelected= { onOptionSelected(option) }
            )
        }
    }
}

@Composable
private fun OptionButton(
    text: String,
    label: String,
    isSelected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
            .selectable(
                selected = isSelected,
                onClick = onOptionSelected,
                role = Role.RadioButton
            )
    ) {
        if (isSelected) {
            RadioButton(
                selected = isSelected,
                onClick = null,
                modifier = Modifier.width(24.dp)
            )
        } else {
            Text(
                text = label,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(24.dp)
            )
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
private fun FlagsQuizScreenPreview() {
    FlagsTheme {
        FlagsQuizScreen(2)
    }
}