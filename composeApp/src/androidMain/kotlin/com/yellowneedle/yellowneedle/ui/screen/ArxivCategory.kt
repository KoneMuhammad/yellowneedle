package com.yellowneedle.yellowneedle.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.yellowneedle.yellowneedle.R


enum class ArxivCategory(val displayName: String, @DrawableRes val iconRes: Int) {
    AI_ML("AI & Machine Learning", iconRes = R.drawable.text_fields_alt_24px),
    ROBOTICS("Robotics", R.drawable.precision_manufacturing_24px),
    Artificial_Intelligence("Artificial Intelligence", R.drawable.calculate_24px),
    Natural_Language_Processing("Natural Language Processing", R.drawable.letter_switch_24px),
    MACHINE_LEARNING("Machine Learning", R.drawable.network_intelligence_24px),
    MULTI_AGENT_SYSTEMS("Multi-Agent Systems", R.drawable.drone_2_24px),
    COMPUTER_VISION("Computer Vision & Pattern Recognition", R.drawable.eyeglasses_2_24px),
}