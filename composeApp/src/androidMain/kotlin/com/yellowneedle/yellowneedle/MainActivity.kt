package com.yellowneedle.yellowneedle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yellowneedle.yellowneedle.ui.screen.SearchArticleBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            SearchArticleBar(
                onQueryChange = TODO(),
                query = TODO(),
                onSearch = TODO(),
                expanded = TODO(),
                onExpandedChange = TODO()
            )
        }
    }
}

