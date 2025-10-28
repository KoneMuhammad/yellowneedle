package com.yellowneedle.yellowneedle.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yellowneedle.yellowneedle.data.dto.ArxivEntry
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.ui.viewmodel.SearchViewModel
import javax.annotation.Untainted
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon

/**
 * image of paper on the left like reference image
 *check eberuthing that the route screen has inside of it
 *SEARCH BY -TITLE,AUTHOR ETC
 *
 */


@Composable
fun SearchScreenRoute(
     viewmodel : SearchViewModel = hiltViewModel())
{
    var userSearchText by remember { mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }

    val allSuggestions = listOf("Kotlin", "Compose", "Android", "Jetpack", "Hilt", "Room")
    var filteredSuggestions by remember { mutableStateOf(allSuggestions) }

SearchScreenLayout(
    arxivFeed = viewmodel.uistate.value.results,
    onQueryChange = {userText -> userSearchText = userText },
    query = userSearchText,
    onSearch = {userSearchText -> viewmodel.getFeedSearchByTitle(userSearchText, start = 0,maxResults = 10,)},
    leadingIcon = {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon"
        )
    },
    placeHolder = {Text("search for research paper")},
    expanded = expanded,
) { newExpanded -> expanded = newExpanded  }
}


@Composable
fun SearchScreenLayout(arxivFeed: ArxivFeed ,onQueryChange: (String) -> Unit, query: String,onSearch: (String) -> Unit, expanded: Boolean, leadingIcon: @Composable () -> Unit,placeHolder: @Composable () -> Unit, onExpandedChange: (Boolean) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchArticleBar(
            onQueryChange = onQueryChange,
            query = query,
            onSearch = onSearch,
            expanded = expanded,
            leadingIcon = leadingIcon,
            placeHolder = placeHolder,
            onExpandedChange = onExpandedChange
        )
ArxivFeedList {arxivFeed}
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchArticleBar(onQueryChange: (String) -> Unit, query: String, onSearch: (String) -> Unit, expanded: Boolean,leadingIcon: @Composable () -> Unit,placeHolder: @Composable () -> Unit,  onExpandedChange: (Boolean) -> Unit) {
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = onSearch,
                expanded = expanded,
                leadingIcon = leadingIcon,
                placeholder = placeHolder,
                onExpandedChange = onExpandedChange,
                modifier = Modifier.fillMaxWidth(),

            )
        },
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = Modifier.fillMaxWidth(),
    ) { }
}

@Preview
@Composable
fun SearchScreenLayoutPreview() {
}