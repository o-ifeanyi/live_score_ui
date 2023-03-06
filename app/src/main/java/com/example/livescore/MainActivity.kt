package com.example.livescore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.livescore.navigation.AppNavigation
import com.example.livescore.navigation.BottomNavigation
import com.example.livescore.navigation.bottomNavItems
import com.example.livescore.ui.theme.LiveScoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveScoreTheme(darkTheme = true, dynamicColor = false) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    val controller = rememberNavController()
                    val navBackStackEntry = controller.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry.value?.destination

                    AppNavigation(controller = controller)
                    AnimatedVisibility(
                        visible = bottomNavItems.any {
                            it.route == currentDestination?.route
                        },
                        modifier = Modifier.align(Alignment.BottomCenter),
                        enter = slideInVertically { it },
                        exit = slideOutVertically { it },
                    ) {
                        BottomNavigation(controller, currentDestination)
                    }
                }
            }
        }
    }
}