package com.example.livescore.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.livescore.ui.screens.auth.AuthScreen
import com.example.livescore.ui.screens.auth.OnboardScreen
import com.example.livescore.ui.screens.explore.ArticleDetailScreen
import com.example.livescore.ui.screens.explore.ExploreScreen
import com.example.livescore.ui.screens.home.HomeScreen
import com.example.livescore.ui.screens.home.MatchDetailScreen
import com.example.livescore.ui.screens.profile.ProfileScreen
import com.example.livescore.ui.screens.search.SearchScreen
import com.example.livescore.ui.screens.standings.StandingsDetailScreen
import com.example.livescore.ui.screens.standings.StandingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(controller: NavHostController) {
    NavHost(navController = controller, startDestination = AppScreens.AuthScreen.name) {
        composable(AppScreens.AuthScreen.name) {
            AuthScreen(navController = controller)
        }
        composable(AppScreens.OnboardScreen.name) {
            OnboardScreen(navController = controller)
        }
        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = controller)
        }
        composable(AppScreens.SearchScreen.name) {
            SearchScreen(navController = controller)
        }
        val detailScreen = AppScreens.MatchDetailScreen.name
        composable(
            "$detailScreen/{matchId}",
            arguments = listOf(navArgument(name = "matchId") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("matchId")
            MatchDetailScreen(navController = controller, matchId = "$id")
        }
        composable(AppScreens.ExploreScreen.name) {
            ExploreScreen(navController = controller)
        }
        val articleDetailScreen = AppScreens.ArticleDetailScreen.name
        composable(
            "$articleDetailScreen/{articleId}",
            arguments = listOf(navArgument(name = "articleId") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("articleId")
            ArticleDetailScreen(navController = controller, articleId = "$id")
        }
        composable(AppScreens.StandingsScreen.name) {
            StandingsScreen(navController = controller)
        }
        val standingsDetailScreen = AppScreens.StandingsDetailScreen.name
        composable(
            "$standingsDetailScreen/{standingId}",
            arguments = listOf(navArgument(name = "standingId") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("standingId")
            StandingsDetailScreen(navController = controller, standingId = "$id")
        }
        composable(AppScreens.ProfileScreen.name) {
            ProfileScreen(navController = controller)
        }
    }
}