package com.yellowneedle.yellowneedle.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yellowneedle.yellowneedle.ui.screen.SearchScreenRoute

@Composable
fun yellowNeedleNavHost(){
    val navcontroller = rememberNavController()
    NavHost(navcontroller, startDestination = "SearchScreenRoute") {
        composable("SearchScreenRoute") {
            SearchScreenRoute()

        }
    }
}
