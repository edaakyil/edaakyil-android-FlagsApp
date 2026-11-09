package com.edaakyil.app.flags.data

import androidx.compose.ui.graphics.painter.Painter

data class Flag(
    val image: Painter,
    val country: String,
    val continent: String
)

