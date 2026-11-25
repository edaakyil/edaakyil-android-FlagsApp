package com.edaakyil.app.flags.ui.aboutme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edaakyil.app.flags.R
import com.edaakyil.app.flags.ui.theme.FlagsTheme

private val purpleColorResId = R.color.purple_on_background
private val backgroundColorResId = R.color.purple_background

private data class ContactInfo(
    @DrawableRes val iconResId: Int,
    @StringRes val typeResId: Int,
    @StringRes val infoResId: Int,
    val url: String = "https://www.google.com"
)

private object Contacts {
    val mailContactInfo = ContactInfo(R.drawable.mail, R.string.mail, R.string.developer_mail_address)
    val githubProfile = ContactInfo(R.drawable.github, R.string.github, R.string.developer_github_profile)
    val linkedinProfile = ContactInfo(R.drawable.linkedin, R.string.linkedin, R.string.developer_linkedin_profile)
}

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(colorResource(backgroundColorResId))
            .fillMaxSize()
        //.padding(horizontal = dimensionResource(R.dimen.padding_large))
    ) {
        ProfileSection()

        Spacer(Modifier.height(16.dp))

        ContactSection(navigateContact = { uriHandler.openUri(it) })
    }
}

@Composable
private fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.flags_app_icon),
            contentDescription = stringResource(R.string.developer_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(R.dimen.profile_image_size))
                //.shadow(elevation = 3.dp, shape = CircleShape)
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        radius = 5.dp,
                        spread = 2.dp,
                        color = Color(0x40000000),
                        offset = DpOffset(x = 1.dp, y = 1.dp)
                    )
                )
                .clip(CircleShape)
        )

        Text(
            text = stringResource(R.string.developer_name),
            style = MaterialTheme.typography.displaySmall,
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            letterSpacing = TextUnit(0.7F, TextUnitType.Sp),
            modifier = Modifier.paddingFromBaseline(top = 80.dp, bottom = 8.dp)
        )

        Text(
            text = stringResource(R.string.developer_title),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(purpleColorResId)
        )
    }
}

@Composable
private fun ContactSection(
    navigateContact: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(bottom = 56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_16))
    ) {
        ContactIcon(
            info = Contacts.mailContactInfo,
            onClick = navigateContact
        )

        VerticalDivider(
            thickness = 2.dp,
            color = Color.Black,
            modifier = Modifier.height(24.dp),
        )

        ContactIcon(
            info = Contacts.linkedinProfile,
            onClick = navigateContact
        )

        VerticalDivider(
            thickness = 2.dp,
            color = Color.Black,
            modifier = Modifier.height(24.dp),
        )

        ContactIcon(
            info = Contacts.githubProfile,
            onClick = navigateContact
        )
    }
}

@Composable
private fun ContactIcon(
    info: ContactInfo,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onClick(info.url) },
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(info.iconResId),
            contentDescription = stringResource(info.typeResId),
            tint = colorResource(purpleColorResId),
            modifier = Modifier
                .size(dimensionResource(R.dimen.contact_icon_size))
        )
    }
}

@Preview(device = Devices.PIXEL, showSystemUi = true)
@Composable
private fun InfoScreenPreview() {
    FlagsTheme {
        InfoScreen()
    }
}