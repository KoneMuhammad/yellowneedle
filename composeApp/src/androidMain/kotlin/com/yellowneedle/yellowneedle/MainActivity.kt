package com.yellowneedle.yellowneedle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yellowneedle.yellowneedle.ui.navigation.YellowNeedleNavHost
import com.yellowneedle.yellowneedle.ui.screen.SearchArticleBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            YellowNeedleNavHost()
        }
    }
}

