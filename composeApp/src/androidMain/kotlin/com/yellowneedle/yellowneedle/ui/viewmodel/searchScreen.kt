package com.yellowneedle.yellowneedle.ui.viewmodel

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.yellowneedle.yellowneedle.data.dto.ArxivEntry
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

// incorporate different view  ie 4 windows for quicker search
//have that one the default

@Composable
fun SearchScreen() {

}

@Composable
fun ArxivFeedList(arxivFeed: ()-> ArxivFeed) {
    LazyColumn {
        items(arxivFeed().entries){
            paper ->
            TitleText {paper}
                AuthorText {paper }
            }
        }
    }
}




@Composable
fun AuthorText(entry: () -> ArxivEntry) {
    val names = entry().authors.joinToString(", ") { it.name ?: "Unknown" }
    BasicText(text = names)

}
@Composable
fun BasicText(text: String) {
    Text(text = text)
}

@Composable
fun TitleText(entry: () -> ArxivEntry) {
    BasicText(entry().title?: "title not found")
}
