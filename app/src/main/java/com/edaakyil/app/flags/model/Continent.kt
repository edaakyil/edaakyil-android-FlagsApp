package com.edaakyil.app.flags.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Continent(
    val id: Int,
    val name: String,
    @DrawableRes val imageResId: Int,
    val countries: Set<Country>
)