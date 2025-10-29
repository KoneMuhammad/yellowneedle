package com.yellowneedle.yellowneedle.ui.screen

import android.content.res.Configuration
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.rememberCoroutineScope
import com.yellowneedle.yellowneedle.data.dto.ArxivAuthor
import kotlinx.coroutines.launch

/**
 * image of paper on the left like reference image
 *check eberuthing that the route screen has inside of it
 *SEARCH BY -TITLE,AUTHOR ETC
 *
 */


@Composable
fun SearchScreenRoute( viewmodel : SearchViewModel = hiltViewModel())
{
    var userSearchText by remember { mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }

 val scope = rememberCoroutineScope()

SearchScreenLayout(
    arxivFeed = viewmodel.uIState.value.results,
    onQueryChange = {userText -> userSearchText = userText },
    query = userSearchText,
    onSearch = {scope.launch {viewmodel.getFeedSearchAll(it, start = 0,maxResults = 10,)}
               expanded = false
        },
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
FeedLazyColumn {arxivFeed}
    }
}

@Composable
fun FeedLazyColumn(arxivFeed: ()-> ArxivFeed) {
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


            )
        },
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) { }
}

@Preview(showBackground = true, )
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FeedLazyColumnPreview() {
    val sampleFeed = ArxivFeed(
        title = "Sample Feed",
        entries = mutableListOf(
            ArxivEntry(title = "Paper 1", authors = mutableListOf(ArxivAuthor("hoha"))),
            ArxivEntry(title = "Paper 2", authors = mutableListOf(ArxivAuthor("pow")))
        )
    )
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(sampleFeed.entries){ entries ->
            Text(entries.title?: "")
            Text(entries.authors.joinToString(","){it.name ?: "Unknown"})

        }
}
}

