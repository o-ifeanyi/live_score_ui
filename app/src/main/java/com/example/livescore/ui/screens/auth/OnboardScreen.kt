package com.example.livescore.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.models.listOfSports
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.CustomButton

@Composable
fun OnboardScreen(navController: NavController) {
    val sportList = listOfSports
    val selectedSports = remember {
        mutableStateListOf(sportList.first())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "What sports are", style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "you interested in?", style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "You can choose more than one",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.outline, fontWeight = FontWeight.Light
                )
            )
        }
        LazyVerticalGrid(
            modifier = Modifier.height(315.dp),
            columns = GridCells.Fixed(3),
        ) {
            items(sportList) {sport ->
                val selected = selectedSports.contains(sport)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 15.dp)
                ) {
                    Button(
                        modifier = Modifier.background(
                            brush = Brush.linearGradient(
                                colors = if (selected) listOf(
                                    MaterialTheme.colorScheme.secondaryContainer,
                                    MaterialTheme.colorScheme.secondary,
                                ) else listOf(
                                    MaterialTheme.colorScheme.onBackground,
                                    MaterialTheme.colorScheme.onBackground,
                                )
                            ),
                            shape = CircleShape
                        ),
                        contentPadding = PaddingValues(24.dp),
                        onClick = {
                            if (selected) selectedSports.remove(sport) else selectedSports.add(
                                sport
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Image(
                            painter = painterResource(id = sport.image),
                            contentDescription = "Sport Image",
                            modifier = Modifier
                                .size(44.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = sport.name, color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
        Column {
            CustomButton(text = "Continue") {
                navController.navigate(AppScreens.HomeScreen.name)
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Skip",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}