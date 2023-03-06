package com.example.livescore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.livescore.R

@Composable
fun HomeBanner() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
        Surface(
            modifier = Modifier
                .height(195.dp)
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.tertiary,
                            MaterialTheme.colorScheme.tertiaryContainer
                        ),
                    ),
                    shape = MaterialTheme.shapes.small,
                )
                .clip(shape = MaterialTheme.shapes.small),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = MaterialTheme.shapes.small
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.soccer),
                            contentDescription = "Football Image",
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "Football",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold, color = Color.Black
                        )

                    }
                }
                Text(
                    text = "Liverpool UEFA\nChampion League\n" +
                            "Celebration"
                )
                Text(
                    text = "Yesterday, 06.30 PM",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.person2),
            contentDescription = "Player Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(185.dp)
                .fillMaxWidth(.5f).padding(end = 20.dp)
                .align(Alignment.BottomEnd)
        )
    }
}