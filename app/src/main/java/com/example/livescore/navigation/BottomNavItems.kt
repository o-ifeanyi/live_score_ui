package com.example.livescore.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddChart
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: @Composable () -> Unit
) {
    object Home : BottomNavItem(
        route = AppScreens.HomeScreen.name,
        label = "Home",
        icon = {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Home Icon",
                tint = MaterialTheme.colorScheme.outline
            )
        },
    )

    object Explore :
        BottomNavItem(
            route = AppScreens.ExploreScreen.name,
            label = "Explore",
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Explore,
                    contentDescription = "Explore Icon",
                    tint = MaterialTheme.colorScheme.outline
                )
            },
        )

    object Standings :
        BottomNavItem(
            route = AppScreens.StandingsScreen.name,
            label = "Standings",
            icon = {
                Icon(
                    imageVector = Icons.Outlined.AddChart,
                    contentDescription = "Standings Icon",
                    tint = MaterialTheme.colorScheme.outline
                )
            },
        )

    object Profile :
        BottomNavItem(
            route = AppScreens.ProfileScreen.name,
            label = "Profile",
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile Icon",
                    tint = MaterialTheme.colorScheme.outline
                )
            },
        )
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Explore,
    BottomNavItem.Standings,
    BottomNavItem.Profile,
)