package com.edaakyil.app.flags.ui.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.ui.theme.FlagsTheme

private val quizList = listOf("Countries", "Flags", "Capital")
enum class QuizType { Countries, Flags, Capital }

@Composable
fun QuizMenuScreen2(
    onStartButtonClicked: (Continent, QuizType) -> Unit,
    modifier: Modifier = Modifier
) {
    var index by rememberSaveable { mutableIntStateOf(0) }
    val options = listOf("Flags", "Countries", "Capitals")
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
                    continent = ContinentsData.continentsList[index],
                    onNextButtonClicked = { if (index < ContinentsData.continentsList.lastIndex) index++ else index = 0 },
                    onPreviousButtonClicked = { if (index > 0) index-- else index = ContinentsData.continentsList.lastIndex },
                )

                SingleChoiceSegmentedButton(
                    options = options,
                    selectedIndex = quizTypeIndex,
                    onQuizTypeChanged = { quizTypeIndex = QuizType.Flags.ordinal },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        
        Button(
            onClick = { onStartButtonClicked(ContinentsData.continentsList[index], QuizType.entries.getOrNull(quizTypeIndex) ?: QuizType.Flags) },
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

@Composable
private fun QuizDropdownMenu(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun QuizMenuScreen2Preview() {
    FlagsTheme {
        QuizMenuScreen2(
            onStartButtonClicked = { _, _ -> }
        )
    }
}