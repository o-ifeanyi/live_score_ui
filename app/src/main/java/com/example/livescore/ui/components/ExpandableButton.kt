package com.example.livescore.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableButton(text: String, image: Int, selected: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(end = 16.dp)) {
        Button(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = if (selected) listOf(
                            MaterialTheme.colorScheme.secondaryContainer,
                            MaterialTheme.colorScheme.secondary,
                        ) else listOf(
                            MaterialTheme.colorScheme.onBackground,
                            MaterialTheme.colorScheme.onBackground,
                        )
                    ),
                    shape = CircleShape,
                ),
            shape = CircleShape,
            contentPadding = PaddingValues(15.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Sport Image",
                    modifier = Modifier
                        .size(24.dp)
                )
                AnimatedVisibility(visible = selected) {
                    Row {
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = text, color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        }
    }
}