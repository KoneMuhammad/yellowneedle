package com.yellowneedle.yellowneedle.ui.viewmodel

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

// incorporate different view  ie 4 windows for quicker search
//have that one the default

@Composable
fun SearchScreen() {

}

@Composable
fun ArxivFeedList(arxivfeed: ()-> ArrayList<ArxivFeed>) {
    LazyColumn {
        items(arxivfeed()){
            arxivfeed ->
            TitleText {arxivfeed}
        }
    }
}

@Composable
fun TitleText(arxivFeed: () -> ArxivFeed) {
    Text(text = arxivFeed().title)
}

