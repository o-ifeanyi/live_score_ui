package com.example.livescore.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCheckBox(
    checkState: MutableState<Boolean>,
    label: String,
    onCheckChanged: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(3.dp)
                .clickable {
                    onCheckChanged.invoke(!checkState.value)
                },
            contentAlignment = Alignment.Center
        ) {
            if (checkState.value) Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checkbox Icon"
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline),
        )
    }
}