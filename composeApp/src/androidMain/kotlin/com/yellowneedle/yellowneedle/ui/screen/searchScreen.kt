package com.yellowneedle.yellowneedle.ui.screen

import android.content.res.Configuration
import androidx.annotation.Size
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yellowneedle.yellowneedle.data.dto.ArxivAuthor
import io.ktor.sse.SPACE
import kotlinx.coroutines.launch

@Composable
fun SearchScreenRoute( viewmodel : SearchViewModel = hiltViewModel())
{
    var userSearchText by remember { mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }

 val scope = rememberCoroutineScope()

SearchScreenLayout(
    arxivFeed = {viewmodel.uIState.value.results},
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
fun SearchScreenLayout(arxivFeed:() -> ArxivFeed ,onQueryChange: (String) -> Unit, query: String,onSearch: (String) -> Unit, expanded: Boolean, leadingIcon: @Composable () -> Unit,placeHolder: @Composable () -> Unit, onExpandedChange: (Boolean) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        SearchArticleBar(
            onQueryChange = onQueryChange,
            query = query,
            onSearch = onSearch,
            expanded = expanded,
            leadingIcon = leadingIcon,
            placeHolder = placeHolder,
            onExpandedChange = onExpandedChange
        )
        Spacer(Modifier.height(20.dp))
FeedLazyColumn(
    arxivFeed = arxivFeed
)
    }
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
@Composable
fun FeedLazyColumn(arxivFeed: ()-> ArxivFeed) {
    LazyColumn(modifier = Modifier.fillMaxWidth())
    {
        items(arxivFeed().entries) { paper ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .border(   width = 0.5.dp,
                        color = Color(0xA4A9B8).copy(alpha = 1f))
                ) {
                SearchScreenText(
                    text = paper.title ?: "title not found",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.weight(1f))
                SearchScreenText(
                    text = paper.published ?: "title not found",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
        }
    }


@Composable
fun SearchScreenText(text: String,
                     fontFamily: FontFamily,
                     fontSize: TextUnit = TextUnit.Unspecified,
                     fontWeight: FontWeight? = null ,
                     color: Color = Color.Black,
                     textAlign: TextAlign? = null,
                     modifier: Modifier = Modifier) {
    Text(text = text,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        modifier = modifier)
}



@Preview(showBackground = true, )
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FeedLazyColumnPreview() {

    val sampleFeed = ArxivFeed(
        entries = mutableListOf(
            ArxivEntry(title = "machine learning for researchers: its the way of the land which should be ",
                published = "published 10.10.2025"), ArxivEntry(title = "machine learning for researchers: its the way of the land which should be ",
                published = "published 10.10.2025")
        )
    )
    LazyColumn() {
        items(sampleFeed.entries) { entries ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .border(   width = 0.5.dp,
                        color = Color(0xA4A9B8).copy(alpha = 1f),
                        shape = MaterialTheme.shapes.small)
            ) {
                SearchScreenText(
                    text = entries.title ?: "title not found",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.weight(1f))
                SearchScreenText(
                    text = entries.published ?: "title not found",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )


            }
        }
}
}
//clipped publish and not showing rest of entries