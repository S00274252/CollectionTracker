package com.example.collectiontracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ConditionColors(
    val mint: Color,
    val good: Color,
    val fair: Color,
    val poor: Color,
    val onBadge: Color
)
val LightConditionColors = ConditionColors(
    mint = Color(0xFF1B7F3B),
    good = Color(0xFF00696E),
    fair = Color(0xFF8A6100),
    poor = Color(0xFFBA1A1A),
    onBadge = Color.White
)
val DarkConditionColors = ConditionColors(
    mint = Color(0xFF7DDB94),
    good = Color(0xFF80D4D9),
    fair = Color(0xFFF5BE48),
    poor = Color(0xFFFFB4AB),
    onBadge = Color(0xFF101414)
)

val LocalConditionColors = staticCompositionLocalOf { LightConditionColors }

val MaterialTheme.conditionColors: ConditionColors
    @Composable
    @ReadOnlyComposable
    get() = LocalConditionColors.current