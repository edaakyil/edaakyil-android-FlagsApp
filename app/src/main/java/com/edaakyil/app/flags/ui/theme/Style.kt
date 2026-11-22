package com.edaakyil.app.flags.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.bottomShadow(
    height: Dp = 8.dp,
    color: Color = Color.Black.copy(alpha = 0.14f)
): Modifier = this.drawBehind {
    val shadowHeightPx = height.toPx()
    drawRect(
        brush = Brush.verticalGradient(
            colors = listOf(color, Color.Transparent),
            startY = size.height - shadowHeightPx,
            endY = size.height
        ),
        topLeft = Offset(0f, size.height - shadowHeightPx),
        size = size.copy(height = shadowHeightPx)
    )
}