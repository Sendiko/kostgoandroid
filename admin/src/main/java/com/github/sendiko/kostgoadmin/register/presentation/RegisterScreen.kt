package com.github.sendiko.kostgoadmin.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sendiko.kostgoandroid.R
import com.github.sendiko.kostgoandroid.core.ui.components.buttons.LargeButton
import com.github.sendiko.kostgoandroid.core.ui.components.textfields.OutlinedTextField
import com.github.sendiko.kostgoandroid.core.ui.components.textfields.SecureOutlinedTextField
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit,
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Empty */ },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(32.dp)
        ) {
            Text(
                text = stringResource(R.string.headline),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.subheadline),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal
            )
            Column(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.fullName,
                    hint = stringResource(R.string.full_name_hint),
                    onValueChange = {
                        onEvent(RegisterEvent.OnFullNameChanged(it))
                    }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    hint = stringResource(R.string.email_hint),
                    keyboardType = KeyboardType.Email,
                    onValueChange = { onEvent(RegisterEvent.OnEmailChanged(it)) }
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.phoneNumber,
                    hint = stringResource(R.string.phone_number_hint),
                    keyboardType = KeyboardType.Phone,
                    onValueChange = { onEvent(RegisterEvent.OnPhoneNumberChanged(it)) }
                )
                SecureOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    hint = stringResource(R.string.password_hint),
                    value = state.password,
                    onValueChange = { onEvent(RegisterEvent.OnPasswordChanged(it)) },
                    onPasswordVisibilityChanged = { onEvent(RegisterEvent.OnPasswordVisibilityChanged(it)) }
                )
                LargeButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onEvent(RegisterEvent.OnRegisterClicked) },
                    text = stringResource(R.string.register_title)
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPrev() {
    KostgoandroidTheme {
        RegisterScreen(
            state = RegisterState(),
            onEvent = {},
            onNavigateBack = {}
        )
    }
}