package com.example.livescore.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.R
import com.example.livescore.models.MatchModel
import com.example.livescore.models.listOfMatchModels
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.AppBar
import com.example.livescore.ui.components.MatchInfoCard
import com.example.livescore.ui.components.TeamImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDetailScreen(navController: NavController, matchId: String) {
    val match = listOfMatchModels.first {
        it.id == matchId
    }
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            AppBar(title = "UEFA Champions League") {
                navController.popBackStack()
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(105.dp), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        TeamImage(image = match.home.image, size = 70.dp, imagePadding = 15.dp)
                        Text(text = match.home.name, style = MaterialTheme.typography.labelLarge)
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${match.homeScore} - ${match.awayScore}",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(text = "90.15", style = MaterialTheme.typography.labelLarge)
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        TeamImage(image = match.away.image, size = 70.dp, imagePadding = 15.dp)
                        Text(text = match.away.name, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
            item {
                val tabItems = listOf("Match Detail", "Line Up", "H2H")
                TabRow(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    selectedTabIndex = selectedTabIndex.value,
                    containerColor = Color.Transparent,
                    divider = {},
                    indicator = {},
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    tabItems.forEach { tab ->
                        val index = tabItems.indexOf(tab)
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
                                Text(text = tab, style = MaterialTheme.typography.labelLarge)
                            }
                        }
                    }
                }
            }
            item {
                when (selectedTabIndex.value) {
                    0 -> MatchDetailInfo(match = match)
                    1 -> LineUpInfo(match = match)
                    else -> Box {}
                }
            }
            item {
                val otherMatches = listOfMatchModels.filter { match ->
                    match.id != matchId
                }.take(2)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Other Match", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "See all", style = MaterialTheme.typography.labelSmall)
                }
                Spacer(modifier = Modifier.height(20.dp))
                otherMatches.forEach { match ->
                    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                        MatchInfoCard(match) {
                            navController.navigate(AppScreens.MatchDetailScreen.name + "/${match.id}") {
                                popUpTo(AppScreens.HomeScreen.name)
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun LineUpInfo(match: MatchModel) {
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }
    val tabItems = listOf(match.home, match.away)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
                    )
                ) {
                    append("Formation  ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
                        color = MaterialTheme.colorScheme.outline,
                    )
                ) {
                    append(match.formation)
                }
            },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            containerColor = Color.Transparent,
            divider = {},
            indicator = {},
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            tabItems.forEach { team ->
                val index = tabItems.indexOf(team)
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
                            .height(30.dp),
                        selected = selected,
                        onClick = {
                            selectedTabIndex.value = index
                        },
                    ) {
                        Text(text = team.name, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.footballfield),
            contentDescription = "Football Field"
        )
    }
}

@Composable
fun MatchDetailInfo(match: MatchModel) {
    val detail = match.matchDetail
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(text = "${detail.hShooting}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.hAttacks}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.hPossession}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.hCards}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.hCorners}", style = MaterialTheme.typography.bodyLarge)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(text = "Shooting", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Attacks", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Possession", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Cards", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Corners", style = MaterialTheme.typography.bodyLarge)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(text = "${detail.aShooting}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.aAttacks}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.aPossession}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.aCards}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${detail.aCorners}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
