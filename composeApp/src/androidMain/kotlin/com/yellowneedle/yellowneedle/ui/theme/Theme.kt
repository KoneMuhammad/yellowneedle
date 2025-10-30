package com.yellowneedle.yellowneedle.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = CalmGray,
    onPrimary = white,
    background = offBlack,
    onBackground = white,
    onSecondary = grey

)

private val LightColorScheme = lightColorScheme(
    primary = CalmGray,          // button face
    onPrimary = black,      // text/icon on blue button
    background = offWhite,
    onBackground = black,
    onSecondary = grey
)

@Composable
fun yellowNeedleTheme(
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