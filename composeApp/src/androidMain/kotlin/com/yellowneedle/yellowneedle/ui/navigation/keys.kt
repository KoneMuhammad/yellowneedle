package com.yellowneedle.yellowneedle.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.yellowneedle.yellowneedle.ui.screen.SearchScreenRoute
import com.yellowneedle.yellowneedle.ui.screen.SummaryScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data object Search {}
@Serializable
data object Summary{}

@Composable
fun NavigationDisplay() {

    val backstack = remember {mutableStateListOf<Any>(Search)}
    NavDisplay(
        backStack = backstack,
        onBack = {backstack.removeLastOrNull()},
        entryProvider = {
            key ->
            when(key) {
                is Search -> NavEntry(key) {
                    SearchScreenRoute()
                }
                is Summary -> NavEntry(key){
                    SummaryScreenRoute()
                }
                else -> NavEntry(Unit){
                    Text("unknown Route")
                }
            }
        }
    )
}



