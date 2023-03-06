package com.example.livescore.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.R
import com.example.livescore.ui.components.CustomButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalMaterial3Api
@Composable
fun AuthScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp),
        sheetBackgroundColor = MaterialTheme.colorScheme.onBackground,
        sheetContentColor = MaterialTheme.colorScheme.onPrimary,
        scrimColor = Color.Black.copy(alpha = .75f),
        sheetContent = {
            AuthModalSheet(
                navController = navController,
                coroutineScope = coroutineScope,
                modalSheetState = modalSheetState
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 40.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                Surface(
                    modifier = Modifier
                        .height(280.dp)
                        .width(290.dp)
                        .clip(shape = MaterialTheme.shapes.large),
                    color = MaterialTheme.colorScheme.onBackground
                ) {}
                Image(
                    painter = painterResource(id = R.drawable.person1),
                    contentDescription = "Player Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.height(325.dp)
                )
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                        .align(alignment = BiasAlignment(-.9f, 1f))
                )
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                        .align(alignment = BiasAlignment(-.75f, -1f))
                )
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colorScheme.tertiary)
                        .align(alignment = BiasAlignment(1f, .4f))
                )
            }
            Spacer(modifier = Modifier.height(65.dp))
            Text(
                text = "Discover all", style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "about sport", style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Search millions of jobs and get the inside scoop on companies.\n" + "Wait for what? Let’s get start it!",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.outline, fontWeight = FontWeight.Light
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CustomButton(text = "Sign in", fraction = .65f) {
                        coroutineScope.launch {
                            modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    }
                    TextButton(onClick = { /*TODO*/ }, contentPadding = PaddingValues(end = 0.dp)) {
                        Text(
                            text = "Sign up",
                            color = MaterialTheme.colorScheme.outline,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }
        }
    }
}

