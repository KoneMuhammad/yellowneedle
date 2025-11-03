package com.yellowneedle.yellowneedle.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    background = offBlack,
    onBackground = whiteText,
    onSecondary = grayText,
    onTertiary = strokeBlack

)

private val LightColorScheme = lightColorScheme(
    background = offWhite,
    onBackground = blackText,
    onSecondary = grayText,
    onTertiary = strokeWhite,

)

@Composable
fun YellowNeedleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = YellowNeedleTypography,
        content = content
    )
}