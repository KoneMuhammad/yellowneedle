package com.yellowneedle.yellowneedle.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = CalmGray,
    onPrimary = white,
    background = offBlack,
    tertiary = OrangeDark,
    onBackground = white,
    onSurface = White,
    onTertiary = White,
    onSurfaceVariant = Lightning

)

private val LightColorScheme = lightColorScheme(
    primary = CalmGray,          // button face
    onPrimary = BlueDark,      // text/icon on blue button
    background = offWhite,
    onBackground = black,
    surface = White,
    tertiary = Orange,
    onSurface = DarkGray,
    onTertiary = Black,
    onSurfaceVariant = Lightning
)