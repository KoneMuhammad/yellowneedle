package com.yellowneedle.yellowneedle.ui.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yellowneedle.yellowneedle.data.dto.ArxivEntry
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

@Composable
fun SearchScreenRoute(){
    val viewmodel : SearchViewModel = hiltViewModel()

ArxivFeedList { viewmodel.uistate.value.results. }
}


@Composable
fun SearchScreenLayout() {
    Column() {

    }
}

@Composable
fun ArxivFeedList(arxivFeed: ()-> ArxivFeed) {
    LazyColumn {
        items(arxivFeed().entries){
            paper ->
            TitleText {paper}
                AuthorNameText {paper }
            }
        }
    }




@Composable
fun AuthorNameText(entry: () -> ArxivEntry) {
    val names = entry().authors.joinToString(", ") { it.name ?: "Unknown" }
    BasicText(text = names)

}

@Composable
fun TitleText(entry: () -> ArxivEntry) {
    BasicText(entry().title?: "title not found")
}

@Composable
fun DatePublishedText(entry: () -> ArxivEntry) {
    BasicText(entry().published?: "date not found")
}


    @Composable
    fun BasicText(text: String) {
        Text(text = text)
    }

@Composable
fun SearchArticleBar(onQueryChange: (String) -> Unit, query: String,onSearch: (String) -> Unit ) {
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = onSearch,
                //lets do with this ^
                expanded = TODO(),
                onExpandedChange = TODO(),
                modifier = TODO(),
                enabled = TODO(),
                placeholder = TODO(),
                leadingIcon = TODO(),
                trailingIcon = TODO(),
                colors = TODO(),
                interactionSource = TODO()
            )
        },
        expanded = TODO(),
        onExpandedChange = TODO(),
        modifier = TODO(),
        shape = TODO(),
        colors = TODO(),
        tonalElevation = TODO(),
        shadowElevation = TODO(),
        windowInsets = TODO()
    ) { }
}