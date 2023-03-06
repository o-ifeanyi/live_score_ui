package com.example.livescore.ui.screens.explore

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.livescore.R
import com.example.livescore.models.listOfArticles

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(navController: NavController, articleId: String) {
    val article = listOfArticles.first {
        it.id == articleId
    }
    Scaffold {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = article.image),
                    contentDescription = "Article Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(342.dp)
                        .clip(shape = RoundedCornerShape(bottomEnd = 42.dp, bottomStart = 42.dp))
                )
            }
            item {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier = Modifier.height(37.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(37.dp)
                                .clip(shape = CircleShape),
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = article.author, style = MaterialTheme.typography.bodySmall)
                            Text(
                                text = article.date,
                                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline)
                            )
                        }
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favourite Button",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "${article.likesCount}",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Icon(
                            imageVector = Icons.Outlined.Comment,
                            contentDescription = "Comment Button",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "${article.commentsCount}",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
            item {
                Text(
                    text = article.body,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 100.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "Back Button"
                    )
                }
                Column {
                    IconButton(
                        modifier = Modifier.size(52.dp),
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.outline.copy(alpha = .7f),
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = "Share Button",
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    IconButton(
                        modifier = Modifier.size(52.dp),
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark Button"
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.secondaryContainer,
                                MaterialTheme.colorScheme.secondary,
                            )
                        ),
                        shape = MaterialTheme.shapes.medium,
                    )
                    .height(56.dp)
                    .width(250.dp)
                    .align(Alignment.BottomCenter),
            ) {
                Text(text = "Read More")
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "More Icon"
                )
            }
        }
    }
}