package com.yellowneedle.yellowneedle.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val YellowNeedleTypography = Typography(
    titleLarge = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Normal, lineHeight = 64.sp, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
    titleMedium = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Normal, lineHeight = 52.sp, letterSpacing = 0.25. sp, fontFamily = FontFamily.SansSerif),

    headlineLarge = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
    headlineMedium = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
    headlineSmall = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),

    bodyLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
    bodyMedium = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
    bodySmall = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),

    displayMedium =  TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.25.sp, fontFamily = FontFamily.SansSerif),
            displaySmall =  TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal, letterSpacing = 0.sp, fontFamily = FontFamily.SansSerif),
)

//line height