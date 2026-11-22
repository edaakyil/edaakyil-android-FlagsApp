package com.edaakyil.app.flags.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Devices.PIXEL_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.model.Country
import com.edaakyil.app.flags.ui.theme.FlagsTheme

@Composable
fun DetailsDialogElement(
    country: Country,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier.fillMaxWidth().padding(all = 8.dp),
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 16.dp, bottomStart = 0.dp, bottomEnd = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
            )
        ) {
            Column() {
                Image(
                    painter = painterResource(country.flagResId),
                    contentDescription = country.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .shadow(elevation = 2.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = country.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 24.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = country.capital,
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFF514A55),
                    modifier = Modifier.padding(start = 24.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(device = PIXEL_XL, showSystemUi = true)
@Composable
private fun DetailsDialogElementPreview() {
    FlagsTheme {
        DetailsDialogElement(
            country = Country(id = 1, name = "Argentina", capital = "Buenos Aires", flagResId = R.drawable.flag_of_argentina_svg),
            onDismissRequest = {}
        )
    }
}