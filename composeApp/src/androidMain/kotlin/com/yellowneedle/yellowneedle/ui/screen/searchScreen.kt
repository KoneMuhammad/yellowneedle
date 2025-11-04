package com.yellowneedle.yellowneedle.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yellowneedle.yellowneedle.ui.theme.YellowNeedleTheme
import kotlinx.coroutines.launch
import com.yellowneedle.yellowneedle.R
import com.yellowneedle.yellowneedle.ui.navigation.Search


@Composable
fun SearchScreenRoute(viewmodel: SearchViewModel = hiltViewModel(), navController: NavHostController) {
    var userSearchText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }


    val scope = rememberCoroutineScope()

    SearchScreenLayout(
        arxivFeed = { viewmodel.uIState.value.results },
        onQueryChange = { userText -> userSearchText = userText },
        query = userSearchText,
        onSearch = {
            scope.launch { viewmodel.getFeedSearchAll(it, start = 0, maxResults = 10) }
            expanded = false
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        placeHolder = { Text("search for research paper") },
        onclick = {navController.navigate(Search.route) },
        expanded = expanded,
    ) { newExpanded -> expanded = newExpanded }
}


@Composable
fun SearchScreenLayout(
    arxivFeed: () -> ArxivFeed,
    onQueryChange: (String) -> Unit,
    query: String,
    onSearch: (String) -> Unit,
    expanded: Boolean,
    leadingIcon: @Composable () -> Unit,
    placeHolder: @Composable () -> Unit,
    onclick: () -> Unit,
    onExpandedChange: (Boolean) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
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
            onclick = onclick,
            arxivFeed = arxivFeed,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchArticleBar(
    onQueryChange: (String) -> Unit,
    query: String,
    onSearch: (String) -> Unit,
    expanded: Boolean,
    leadingIcon: @Composable () -> Unit,
    placeHolder: @Composable () -> Unit,
    onExpandedChange: (Boolean) -> Unit
) {
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
fun FeedLazyColumn(arxivFeed: () -> ArxivFeed, onclick: () -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth())
    {
        items(arxivFeed().entries) { paper ->
            val isMarqueeOn = remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .border(
                        width = 0.5.dp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                    .clipToBounds()
                    .clickable(onClick = onclick )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { isMarqueeOn.value = true },
                            onPress = {
                                awaitRelease()
                                isMarqueeOn.value = false
                            }
                        )
                    },
            ) {
                Icon(
                    modifier = Modifier
                        .height(48.dp)
                        .width(44.dp)
                        .padding(
                            start = 11.dp, top = 13.dp, end = 11.dp, bottom = 13.dp
                        )
                        .align(Alignment.CenterStart)
                        .offset(x = 24.dp),
                    painter = painterResource(R.drawable.precision_manufacturing_24px), contentDescription = "",
                    tint = MaterialTheme.colorScheme.onBackground
                )
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .offset(x = 84.dp)) {
                    Spacer(modifier = Modifier.height(24.dp))
                    SearchScreenText(
                        text = paper.title ?: "title not found",
                        textStyle = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = if (isMarqueeOn.value) {
                            Modifier.basicMarquee()
                        } else {
                            Modifier.width(265.dp)
                        }

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SearchScreenText(
                        text = paper.published ?: "title not found",
                        textStyle = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .width(266.dp)
                            .align(Alignment.Start)

                    )
                }
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterEnd)
                        .offset(x = -24.dp),
                    painter = painterResource(R.drawable.arrow_forward_ios_24px), contentDescription = "",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}


@Composable
fun SearchScreenText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = 1,
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
    )
}


@Preview(showBackground = true, widthDp = 411)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode", widthDp = 411)
@Composable
fun FeedLazyColumnPreview() {
    YellowNeedleTheme {
        val sampleFeed = ArxivFeed(
            entries = mutableListOf(
                ArxivEntry(
                    title = "machine learning for researchers: its the way of the land which should be ",
                    published = "published 10.10.2025"
                ), ArxivEntry(
                    title = "machine learning for researchers: its the way of the land which should be ",
                    published = "published 10.10.2025"
                )
            )
        )
        var isMarqueeOn by remember { mutableStateOf(false) }
        val textWidth = remember { mutableStateOf(0) }
        val boxWidth = remember { mutableStateOf(0) }

        LazyColumn() {
            items(sampleFeed.entries) { entries ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .border(
                            width = 0.5.dp,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                        .clipToBounds()
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onLongPress = { isMarqueeOn = true },
                                onPress = {
                                    awaitRelease()
                                    isMarqueeOn = false
                                }
                            )
                        },
                ) {
                    Icon(
                        modifier = Modifier
                            .height(48.dp)
                            .width(44.dp)
                            .padding(
                                start = 11.dp, top = 13.dp, end = 11.dp, bottom = 13.dp
                            )
                            .align(Alignment.CenterStart)
                            .offset(x = 24.dp),
                        painter = painterResource(R.drawable.precision_manufacturing_24px), contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )

                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .offset(x = 84.dp)) {
                        Spacer(modifier = Modifier.height(24.dp))
                        SearchScreenText(
                            text = entries.title ?: "title not found",
                            textStyle = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = if (isMarqueeOn) {
                                Modifier.basicMarquee()
                            } else {
                                Modifier.width(266.dp)
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SearchScreenText(
                            text = entries.published ?: "title not found",
                            textStyle = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier
                                .width(266.dp)
                                .align(Alignment.Start)

                        )
                    }
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .align(Alignment.CenterEnd)
                            .offset(x = -24.dp),
                        painter = painterResource(R.drawable.arrow_forward_ios_24px), contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}
//clipped publish and not showing rest of entries