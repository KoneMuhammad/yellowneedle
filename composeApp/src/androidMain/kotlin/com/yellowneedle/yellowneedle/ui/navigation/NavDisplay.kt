package com.yellowneedle.yellowneedle.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.yellowneedle.yellowneedle.ui.screen.SearchScreenRoute
import com.yellowneedle.yellowneedle.ui.screen.SummaryScreenRoute
import com.yellowneedle.yellowneedle.ui.viewmodel.SearchViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Search
@Serializable
data class Summary(val index : Int)

@Composable
fun NavigationDisplay() {
val viewmodel: SearchViewModel = hiltViewModel()
    val backstack = remember {mutableStateListOf<Any>(Search)}
    NavDisplay(
        backStack = backstack,
        onBack = {backstack.removeLastOrNull()},
        entryProvider = {
            key ->
            when(key) {
                is Search -> NavEntry(key) {
                    SearchScreenRoute(
                        viewmodel = viewmodel,
                        onNavigateTo = { index -> backstack.add(Summary(index)) }
                    )
                }
                is Summary -> NavEntry(key){
                    SummaryScreenRoute(
                        viewmodel = viewmodel,
                         INDEX = key.index)
                }
                else -> NavEntry(Unit){
                    Text("unknown Route")
                }
            }
        }
    )
}



