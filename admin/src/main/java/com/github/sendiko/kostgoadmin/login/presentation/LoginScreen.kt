package com.github.sendiko.kostgoadmin.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sendiko.kostgoandroid.R
import com.github.sendiko.kostgoandroid.core.ui.components.AppLogo
import com.github.sendiko.kostgoandroid.core.ui.components.buttons.LargeButton
import com.github.sendiko.kostgoandroid.core.ui.components.textfields.OutlinedTextField
import com.github.sendiko.kostgoandroid.core.ui.components.textfields.SecureOutlinedTextField
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme
import com.github.sendiko.kostgoandroid.core.ui.theme.PrimaryOrange

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
) {

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppLogo()
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.email,
                onValueChange = { onEvent(LoginEvent.OnEmailChanged(it)) },
                hint = stringResource(R.string.email_hint),
                isError = state.isError,
                keyboardType = KeyboardType.Email
            )
            SecureOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.password,
                hint = stringResource(R.string.password_hint),
                onValueChange = { onEvent(LoginEvent.OnPasswordChanged(it)) },
                onPasswordVisibilityChanged = { onEvent(LoginEvent.OnPasswordVisibilityChanged(it)) }
            )
            LargeButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onEvent(LoginEvent.OnLoginClicked) },
                text = "Login"
            )
            TextButton(
                onClick = { }
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.register_hint),
                    textAlign = TextAlign.Center,
                    color = PrimaryOrange
                )
            }
        }
    }

}

@Preview
@Composable
private fun LoginScreenPrev() {
    KostgoandroidTheme {
        LoginScreen(
            state = LoginState(),
            onEvent = {}
        )
    }
}