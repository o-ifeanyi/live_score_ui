package com.example.livescore.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.*
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val sportList = listOfSports
    val selectedSport = remember {
        mutableStateOf(sportList.first())
    }
    val matches = listOfMatchModels.take(3)
    Scaffold(
        topBar = {
            AppBar(
                title = "Live Score",
                titleStyle = MaterialTheme.typography.titleSmall,
                hasBackButton = false,
                actions = {
                    IconButton(onClick = { navController.navigate(AppScreens.SearchScreen.name) }) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search Button"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Search Button"
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                HomeBanner()
            }
            item {
                LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                    items(sportList) { sport ->
                        SportListItem(
                            sport = sport,
                            selected = selectedSport.value == sport
                        ) {
                            selectedSport.value = sport
                        }
                    }
                }
            }
            item {
                matches.forEach { match ->
                    val league = match.league
                    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                        IconListTile(
                            icon = {
                                Image(
                                    painter = painterResource(id = league.countryImage),
                                    contentDescription = "Team Flag",
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            title = league.name,
                            subtitle = league.country,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        MatchInfoCard(match) {
                            navController.navigate(AppScreens.MatchDetailScreen.name + "/${match.id}")
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun SportListItem(sport: SportModel, selected: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(end = 16.dp)) {
        Button(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = if (selected) listOf(
                            MaterialTheme.colorScheme.secondaryContainer,
                            MaterialTheme.colorScheme.secondary,
                        ) else listOf(
                            MaterialTheme.colorScheme.onBackground,
                            MaterialTheme.colorScheme.onBackground,
                        )
                    ),
                    shape = MaterialTheme.shapes.small,
                )
                .width(110.dp)
                .height(115.dp),
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(horizontal = 10.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = sport.image),
                    contentDescription = "Sport Image",
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = sport.name, color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

