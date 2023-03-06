package com.example.livescore.ui.screens.standings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.listOfSports
import com.example.livescore.models.listOfStandings
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.ExpandableButton
import com.example.livescore.ui.components.IconListTile
import com.example.livescore.ui.components.InputField
import com.example.livescore.ui.components.LeagueInfoCard

@ExperimentalMaterial3Api
@Composable
fun StandingsScreen(navController: NavController) {
    val searchInput = remember {
        mutableStateOf("")
    }
    val standings = listOfStandings
    val sportList = listOfSports
    val selectedSport = remember {
        mutableStateOf(sportList.first())
    }
    Scaffold(
        topBar = {
            Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                InputField(
                    modifier = Modifier.padding(20.dp),
                    input = searchInput,
                    label = "Search your competition ...",
                    leadingIcon = Icons.Rounded.Search,
                    background = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                    items(sportList) { sport ->
                        ExpandableButton(
                            text = sport.name,
                            image = sport.image,
                            selected = sport == selectedSport.value
                        ) {
                            selectedSport.value = sport
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                standings.forEach { standing ->
                    val league = standing.league
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
                        LeagueInfoCard(standing) {
                            navController.navigate(AppScreens.StandingsDetailScreen.name + "/${standing.id}")
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}