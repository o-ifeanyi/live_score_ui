package com.example.livescore.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.HideSource
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livescore.navigation.AppScreens
import com.example.livescore.ui.components.CustomButton
import com.example.livescore.ui.components.InputField
import com.example.livescore.ui.components.RoundedCheckBox
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalMaterial3Api
@Composable
fun AuthModalSheet(
    navController: NavController,
    coroutineScope: CoroutineScope,
    modalSheetState: ModalBottomSheetState
) {
    val emailInput = remember { mutableStateOf("") }
    val passwordInput = remember { mutableStateOf("") }
    val checkState = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Divider(
            modifier = Modifier.width(60.dp),
            thickness = 4.dp,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(modifier = Modifier.height(30.dp))
        InputField(input = emailInput, label = "Email", leadingIcon = Icons.Outlined.Email)
        Spacer(modifier = Modifier.height(25.dp))
        InputField(
            input = passwordInput,
            label = "Password",
            leadingIcon = Icons.Outlined.Key,
            suffix = {
                Icon(
                    imageVector = Icons.Outlined.HideSource,
                    contentDescription = "Toggle Password Visibility",
                    tint = MaterialTheme.colorScheme.outline,
                )
            })
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedCheckBox(checkState = checkState, label = "Remember me") {
                checkState.value = it
            }
            Text(
                text = "Forgot password?",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(text = "Sign in") {
            coroutineScope.launch {
                modalSheetState.hide()
                navController.navigate(AppScreens.OnboardScreen.name)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onPrimary)) {
                    append("Don't have an account?")
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.tertiary)) {
                    append(" Sign up")
                }
            },
            style = MaterialTheme.typography.labelMedium,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}