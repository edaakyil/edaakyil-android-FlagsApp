package com.edaakyil.app.flags.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Country(
    val id: Int,
    val name: String,
    val code: String = "",
    val capital: String,
    @DrawableRes val flagResId: Int,
    val nationalLanguage: String = "",
)