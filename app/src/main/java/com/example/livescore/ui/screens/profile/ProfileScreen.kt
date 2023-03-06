package com.example.livescore.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.R
import com.example.livescore.models.user
import com.example.livescore.ui.components.IconListTile

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(navController: NavController) {
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }

    Scaffold {
        LazyColumn(
            contentPadding = PaddingValues(vertical = it.calculateTopPadding(), horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(110.dp)
                            .clip(shape = CircleShape),
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary,
                                shape = CircleShape
                            )
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.background,
                                shape = CircleShape
                            )
                            .padding(0.dp)
                            .align(BiasAlignment(1f, .9f)),
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit Icon",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Brian Immanuel", style = MaterialTheme.typography.titleSmall)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "#YNWK till the end \uD83D\uDD25",
                        style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline)
                    )
                }
            }
            item {
                val tabItems = listOf("My Profile", "Activity", "Settings")
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
                val user = user
                Column {
                    IconListTile(
                        icon = {
                            ListTileIcon(icon = Icons.Outlined.Person)
                        },
                        title = "Name", subtitle = user.name,
                    )
                    Divider(
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 45.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                    )
                    IconListTile(
                        icon = {
                            ListTileIcon(icon = Icons.Outlined.Email)
                        },
                        title = "Email", subtitle = user.email,
                    )
                    Divider(
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 45.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                    )
                    IconListTile(
                        icon = {
                            ListTileIcon(icon = Icons.Outlined.Call)
                        },
                        title = "Phone", subtitle = user.phone,
                    )
                    Divider(
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 45.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                    )
                    IconListTile(
                        icon = {
                            ListTileIcon(icon = Icons.Outlined.LocationOn)
                        },
                        title = "Address", subtitle = user.address,
                    )
                    Divider(
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 45.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ListTileIcon(icon: ImageVector) {
    Surface(
        modifier = Modifier.size(32.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(16.dp)
                .padding(8.dp)
        )
    }
}
