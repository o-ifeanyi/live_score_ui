package com.example.livescore.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController

@Composable
fun BottomNavigation(controller: NavHostController, currentDestination: NavDestination?) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.onBackground) {

        bottomNavItems.forEach { screen ->
            val selected = currentDestination?.route == screen.route
            NavigationBarItem(
                selected = selected,
                icon = if (selected) {
                    {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = screen.label,
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .size(5.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.tertiary,
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                } else screen.icon,
                onClick = {
                    controller.navigate(screen.route) {
                        popUpTo(AppScreens.HomeScreen.name) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}