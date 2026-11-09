package com.edaakyil.app.flags.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun StarButton(
    isStarted: Boolean,
    onStarIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onStarIconClicked
    ) {
        Icon(
            painter = painterResource(if (!isStarted) R.drawable.star else R.drawable.star_filled),
            contentDescription = stringResource(R.string.star_icon)
        )
    }
}

@Preview
@Composable
private fun StarButtonPreview() {
    FlagsTheme {
        StarButton(
            isStarted = false,
            onStarIconClicked = {}
        )
    }
}