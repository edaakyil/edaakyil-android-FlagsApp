package com.edaakyil.app.flags.ui.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun QuizMenuScreen(
    onStartButtonClicked: (Int, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var continentIndex by rememberSaveable { mutableIntStateOf(0) }
    val quizTypes = listOf("Flags", "Capitals")
    var quizTypeIndex by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier.padding(all = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContinentOptionElement(
                    continent = ContinentsData.continentsList[continentIndex],
                    onNextButtonClicked = { if (continentIndex < ContinentsData.continentsList.lastIndex) continentIndex++ else continentIndex = 0 },
                    onPreviousButtonClicked = { if (continentIndex > 0) continentIndex-- else continentIndex = ContinentsData.continentsList.lastIndex },
                )

                SingleChoiceSegmentedButton(
                    options = quizTypes,
                    selectedIndex = quizTypeIndex,
                    onQuizTypeChanged = { quizTypeIndex = it },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        
        Button(
            onClick = { onStartButtonClicked(quizTypeIndex, continentIndex) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Let's start")
        }
    }
}

@Composable
fun ContinentOptionElement(
    continent: Continent,
    onNextButtonClicked: () -> Unit,
    onPreviousButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(
            onClick = onPreviousButtonClicked,
            modifier = Modifier.offset(y = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_back_ios),
                contentDescription = stringResource(R.string.back)
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = continent.name,
                modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
            )

            Image(
                painter = painterResource(continent.imageResId),
                contentDescription = continent.name,
                contentScale = ContentScale.Fit,
            )
        }

        IconButton(
            onClick = onNextButtonClicked,
            modifier = Modifier.offset(y = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_forward_ios),
                contentDescription = stringResource(R.string.forward)
            )
        }
    }
}

@Composable
fun SingleChoiceSegmentedButton(
    options: List<String>,
    selectedIndex: Int,
    onQuizTypeChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(modifier = modifier) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { onQuizTypeChanged(index) },
                label = { Text(text = label) },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                )
            )
        }
    }
}

//@Composable
//private fun QuizDropdownMenu(modifier: Modifier = Modifier) {
//
//}

@Preview
@Composable
private fun QuizMenuScreenPreview() {
    FlagsTheme {
        QuizMenuScreen(
            onStartButtonClicked = { _, _ -> }
        )
    }
}