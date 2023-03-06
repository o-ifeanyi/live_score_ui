package com.example.livescore.ui.screens.standings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.listOfStandings
import com.example.livescore.ui.components.AppBar

@ExperimentalMaterial3Api
@Composable
fun StandingsDetailScreen(navController: NavController, standingId: String) {
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }
    val standing = listOfStandings.first {
        it.id == standingId
    }

    Scaffold(
        topBar = {
            AppBar(title = standing.league.country) {
                navController.popBackStack()
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding(), horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Surface(
                    modifier = Modifier.size(110.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    Image(
                        painter = painterResource(id = standing.league.leagueImage),
                        contentDescription = "League Image",
                        modifier = Modifier
                            .size(75.dp)
                            .padding(15.dp)
                    )
                }
            }
            item {
                Text(text = standing.league.name, style = MaterialTheme.typography.titleSmall)
            }
            item {
                val tabItems = listOf("All", "Home", "Away")
                TabRow(
                    selectedTabIndex = selectedTabIndex.value,
                    containerColor = Color.Transparent,
                    divider = {},
                    indicator = {},
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    tabItems.forEach { item ->
                        val index = tabItems.indexOf(item)
                        val selected = selectedTabIndex.value == index
                        Box(modifier = Modifier.clip(shape = MaterialTheme.shapes.medium)) {
                            Tab(
                                modifier = Modifier
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = if (selected) listOf(
                                                MaterialTheme.colorScheme.secondaryContainer,
                                                MaterialTheme.colorScheme.secondary,
                                            ) else listOf(
                                                MaterialTheme.colorScheme.background,
                                                MaterialTheme.colorScheme.background,
                                            )
                                        ),
                                        shape = MaterialTheme.shapes.medium,
                                    )
                                    .height(46.dp),
                                selected = selected,
                                onClick = {
                                    selectedTabIndex.value = index
                                },
                            ) {
                                Text(text = item, style = MaterialTheme.typography.labelLarge)
                            }
                        }
                    }
                }
            }
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(fraction = .5f)) {
                        Text(text = "# Team", style = MaterialTheme.typography.labelSmall)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "W", style = MaterialTheme.typography.labelSmall)
                        Text(text = "D", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Ga", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Gd", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Pts", style = MaterialTheme.typography.labelSmall)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.height(10.dp))
                standing.teamStanding.forEach { item ->
                    val index = standing.teamStanding.indexOf(item)
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.padding(vertical = 5.dp),
                        color = when (index) {
                            in 0..2 -> Color(0xFF14274D)
                            in 3..4 -> Color(0xFF441818)
                            else -> MaterialTheme.colorScheme.background
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 15.dp)
                        ) {
                            Row(modifier = Modifier.fillMaxWidth(fraction = .5f)) {
                                Text(text = "${index + 1}", style = MaterialTheme.typography.labelSmall)
                                Spacer(modifier = Modifier.width(10.dp))
                                Image(
                                    painter = painterResource(id = item.team.image),
                                    contentDescription = "Team Image",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = item.team.name,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(1f),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${item.win}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = "${item.draw}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = "${item.ga}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = "${item.gd}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = "${item.pts}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

