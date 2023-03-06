package com.example.livescore.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.livescore.models.StandingModel

@Composable
fun LeagueInfoCard(standing: StandingModel, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(fraction = .5f)) {
                    Text(text = "Team", style = MaterialTheme.typography.labelSmall)
                }
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "W", style = MaterialTheme.typography.labelSmall)
                        Text(text = "D", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Ga", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Gd", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Pts", style = MaterialTheme.typography.labelSmall)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(color = MaterialTheme.colorScheme.background)
                }
            }
            standing.teamStanding.take(4).forEach { item ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth(fraction = .5f)) {
                        Image(
                            painter = painterResource(id = item.team.image),
                            contentDescription = "Team Image",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = item.team.name, style = MaterialTheme.typography.labelSmall)
                    }
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(1f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "${item.win}", style = MaterialTheme.typography.labelSmall)
                            Text(text = "${item.draw}", style = MaterialTheme.typography.labelSmall)
                            Text(text = "${item.ga}", style = MaterialTheme.typography.labelSmall)
                            Text(text = "${item.gd}", style = MaterialTheme.typography.labelSmall)
                            Text(text = "${item.pts}", style = MaterialTheme.typography.labelSmall)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider(color = MaterialTheme.colorScheme.background)
                    }
                }
            }
        }
    }
}