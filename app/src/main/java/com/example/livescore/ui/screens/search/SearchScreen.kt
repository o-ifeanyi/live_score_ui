package com.example.livescore.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.listOfMatchModels
import com.example.livescore.models.listOfSearchCategory
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.ExpandableButton
import com.example.livescore.ui.components.InputField
import com.example.livescore.ui.components.TeamImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    val searchInput = remember {
        mutableStateOf("")
    }
    val categories = listOfSearchCategory
    val selectedCategory = remember {
        mutableStateOf(categories.first())
    }
    Scaffold(
        topBar = {
            Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    InputField(
                        modifier = Modifier.fillMaxWidth(fraction = .8f),
                        input = searchInput,
                        label = "Search your team ...",
                        leadingIcon = Icons.Rounded.Search,
                        background = MaterialTheme.colorScheme.onBackground
                    )
                    TextButton(
                        onClick = { navController.popBackStack() },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Cancel",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                    items(categories) { category ->
                        ExpandableButton(
                            text = category.name,
                            image = category.image,
                            selected = category == selectedCategory.value
                        ) {
                            selectedCategory.value = category
                        }
                    }
                }
            }
            items(listOfMatchModels.plus(listOfMatchModels).plus(listOfMatchModels)) { match ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clickable {
                            navController.navigate(AppScreens.MatchDetailScreen.name + "/${match.id}")
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Box(modifier = Modifier.width(78.dp)) {
                        TeamImage(
                            modifier = Modifier.align(BiasAlignment(.8f, 0f)),
                            image = match.away.image,
                            backgroundColor = MaterialTheme.colorScheme.onBackground,
                            borderColor = MaterialTheme.colorScheme.background,
                        )
                        TeamImage(
                            modifier = Modifier.align(BiasAlignment(-.8f, 0f)),
                            image = match.home.image,
                            backgroundColor = MaterialTheme.colorScheme.onBackground,
                            borderColor = MaterialTheme.colorScheme.background,
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth(fraction = .85f)
                    ) {
                        Text(
                            text = "${match.home.name} vs ${match.away.name}",
                            style = MaterialTheme.typography.labelLarge,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Monday, 12 Feb 2021 . 02.30 am",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.outline
                            )
                        )
                    }
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = "Cancel Button",
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}