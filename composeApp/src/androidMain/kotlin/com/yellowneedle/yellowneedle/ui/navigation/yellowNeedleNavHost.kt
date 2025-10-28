package com.yellowneedle.yellowneedle.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yellowneedle.yellowneedle.ui.screen.SearchScreenRoute

@Composable
fun YellowNeedleNavHost(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = SearchDestination.route) {
        composable(SearchDestination.route) {
            SearchScreenRoute()
        }
    }
}
