package com.edaakyil.app.flags.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun AppDrawer() {
    ModalDrawerSheet {
        JetNewsLogo(modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp))

        HorizontalDivider()

        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.home_title)) },
            icon = { Icon(painterResource(R.drawable.home_filled), null) },
            selected = false,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.interests_title)) },
            icon = { Icon(painterResource(R.drawable.list_alt_filled), null) },
            selected = false,
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        HorizontalDivider()
    }
}

@Composable
private fun JetNewsLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.flag_circle),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.width(8.dp))

        Text(stringResource(R.string.app_name))
    }
}

@Preview
@Composable
private fun AppDrawerPreview() {
    FlagsTheme {
        AppDrawer()
    }
}