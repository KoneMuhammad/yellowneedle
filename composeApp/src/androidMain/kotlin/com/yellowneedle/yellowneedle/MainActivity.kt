package com.yellowneedle.yellowneedle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yellowneedle.yellowneedle.ui.navigation.NavigationDisplay
import com.yellowneedle.yellowneedle.ui.theme.YellowNeedleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            YellowNeedleTheme {
                NavigationDisplay()
            }
        }
    }
}
