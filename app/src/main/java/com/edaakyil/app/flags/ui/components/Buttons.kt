package com.edaakyil.app.flags.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edaakyil.app.flags.R

@Composable
fun QuizButtonGroup(
    onSkipButtonClicked: () -> Unit,
    onSubmitButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onSubmitButtonClicked,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = stringResource(R.string.submit),
                fontSize = 16.sp
            )
        }

        OutlinedButton(
            onClick = onSkipButtonClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.skip),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun NavigationButtonsRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Button(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Back",
                fontSize = 16.sp
            )
        }

        Button(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Next",
                fontSize = 16.sp
            )
        }
    }
}