package com.example.livescore.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@ExperimentalMaterial3Api
@Composable
fun AppBar(
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.bodySmall,
    actions: @Composable (RowScope.() -> Unit) = {},
    hasBackButton: Boolean = true,
    onBackPressed: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
            if (hasBackButton) {
                IconButton(
                    onClick = onBackPressed,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back Button",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        title = {
            Text(
                text = title,
                style = titleStyle,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        actions = actions
    )
}