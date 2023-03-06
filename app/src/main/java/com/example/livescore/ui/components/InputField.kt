package com.example.livescore.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    input: MutableState<String>,
    label: String,
    background: Color = MaterialTheme.colorScheme.background,
    obscureText: Boolean = false,
    leadingIcon: ImageVector? = null,
    suffix: @Composable() (() -> Unit)? = null
) {
    TextField(
        value = input.value,
        placeholder = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline),
                )
            }
        },
        onValueChange = {
            input.value = it
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.labelMedium,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp),
        leadingIcon = {
            if (leadingIcon != null) Icon(
                imageVector = leadingIcon,
                contentDescription = " Prefix Icon",
                tint = MaterialTheme.colorScheme.outline,
            )
        },
        suffix = suffix,
        visualTransformation = if (obscureText) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = background
        )
    )
}