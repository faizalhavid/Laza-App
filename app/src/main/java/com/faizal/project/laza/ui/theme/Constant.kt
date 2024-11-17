package com.faizal.project.laza.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class AppThemeSize {
    XS,
    S,
    M,
    L,
    XL,
}
val APP_LAYOUT_PADDING:Map<String, List<Dp>> = mapOf(
    "S" to listOf(12.dp, 16.dp),
    "M" to listOf(16.dp, 24.dp),
    "L" to listOf(24.dp, 28.dp),
    "XL" to listOf(28.dp, 32.dp),
)
