package com.example.livescore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.livescore.models.MatchModel

@Composable
fun MatchInfoCard(match: MatchModel, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(fraction = .87f)
                    .fillMaxHeight(),
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .07f),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Box(modifier = Modifier.width(78.dp)) {
                        TeamImage(
                            modifier = Modifier.align(BiasAlignment(.8f, 0f)),
                            image = match.away.image
                        )
                        TeamImage(
                            modifier = Modifier.align(BiasAlignment(-.8f, 0f)),
                            image = match.home.image
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${match.home.name} vs ${match.away.name}",
                            style = MaterialTheme.typography.labelLarge
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${match.homeScore}    -    ${match.awayScore}",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .fillMaxHeight(),
                color = MaterialTheme.colorScheme.onBackground,
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "HT", style = MaterialTheme.typography.labelLarge)
                }
            }
        }
    }
}

@Composable
fun TeamImage(
    modifier: Modifier = Modifier,
    image: Int,
    size: Dp = 40.dp,
    imagePadding: Dp = 8.dp,
    borderColor: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
) {
    Surface(
        modifier = modifier
            .size(size)
            .border(
                width = 3.dp,
                color = borderColor,
                shape = CircleShape
            ),
        color = backgroundColor,
        shape = CircleShape,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Team Image",
            modifier = Modifier.padding(imagePadding)
        )
    }
}