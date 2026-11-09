package com.edaakyil.app.flags.ui.interests

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun InterestsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("InterestsScreen")
    }
}


data class Song(
    val title: String,
    val description: String
)

@Composable
fun SongScreen(
    modifier: Modifier = Modifier
) {
    val songs = listOf(
        Song(
            title = "Fragile (2020)",
            description = "Glass Souls’ · 3rd Album"
        ),
        Song(
            title = "New Men (2020)",
            description = "Glass Souls’ · Single"
        ),
        Song(
            title = "Runnin’ (2019)",
            description = "Glass Souls’ · 2nd Album"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFF7FF))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
    ) {
        ConcertCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Listen to their biggest hits",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        songs.forEachIndexed { index, song ->
            SongItem(song = song)

            // Son elemandan sonra divider çizilmez.
            if (index < songs.lastIndex) {
                HorizontalDivider(
                    color = Color(0xFFD0C6D2),
                    thickness = 1.dp
                )
            }
        }
    }
}




@Composable
fun ConcertCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F1FA)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "Glass Souls’ World Tour",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF242127),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "From your recent favorites",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF514A55)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    // Bilet satın alma işlemi
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF68529A)
                ),
                contentPadding = PaddingValues(
                    horizontal = 30.dp,
                    vertical = 14.dp
                )
            ) {
                Text(
                    text = "Buy tickets",
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}


@Composable
fun SongItem(
    song: Song,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF242127)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = song.description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF514A55)
            )
        }

        IconButton(
            onClick = {
                // Şarkıyı oynatma işlemi
            }
        ) {
            Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = "Play ${song.title}",
                tint = Color(0xFF514A55),
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
