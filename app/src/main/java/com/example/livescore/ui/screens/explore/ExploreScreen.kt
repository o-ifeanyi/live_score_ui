package com.example.livescore.ui.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.ArticleModel
import com.example.livescore.models.listOfArticles
import com.example.livescore.models.listOfSports
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.ExpandableButton
import com.example.livescore.ui.components.InputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(navController: NavController) {
    val searchInput = remember {
        mutableStateOf("")
    }
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
                    label = "Search for news, team, match, etc...",
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
            items(listOfArticles.take(4)) { news ->
                NewsItem(news) {
                    navController.navigate(AppScreens.ArticleDetailScreen.name + "/${news.id}")
                }
            }
            item {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trending News",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                        items(listOfArticles.takeLast(2)) { news ->
                            Box(
                                modifier = Modifier
                                    .width(270.dp)
                                    .height(190.dp)
                                    .padding(end = 16.dp)
                                    .clip(shape = MaterialTheme.shapes.small)
                                    .clickable {
                                        navController.navigate(AppScreens.ArticleDetailScreen.name + "/${news.id}")
                                    }
                            ) {
                                Image(
                                    painter = painterResource(id = news.image),
                                    contentDescription = "Article Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color = Color.Black.copy(alpha = .3f))
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .align(Alignment.BottomStart),
                                ) {
                                    Text(
                                        text = news.title,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Spacer(modifier = Modifier.height(15.dp))
                                    Text(
                                        text = news.date,
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun NewsItem(news: ArticleModel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(horizontal = 20.dp)
            .clickable { onClick.invoke() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Image(
            painter = painterResource(id = news.image),
            contentDescription = "Article Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(70.dp)
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(fraction = .85f)
                .padding(vertical = 2.dp)
        ) {
            Text(
                text = news.title,
                style = MaterialTheme.typography.labelLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = news.date,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.outline
                )
            )
        }
        Icon(
            imageVector = Icons.Outlined.BookmarkBorder,
            contentDescription = "Bookmark Button",
            tint = MaterialTheme.colorScheme.outline
        )
    }
}

