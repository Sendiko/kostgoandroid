package com.github.sendiko.kostgoandroid.admin.core.presentation.textfields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.github.sendiko.kostgoandroid.R
import com.github.sendiko.kostgoandroid.core.ui.theme.PrimaryOrange

/**
 *
 * Kost Go's custom secured OutlinedTexfields
 *
 * */
@Composable
fun SecureOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onPasswordVisibilityChanged: (Boolean) -> Unit,
    hint: String? = null,
    isPasswordVisible: Boolean = false,
    isError: Boolean = false,
    supportingText: String? = null
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = PrimaryOrange,
            focusedBorderColor = PrimaryOrange,
            cursorColor = PrimaryOrange
        ),
        placeholder = {
            hint?.let {
                Text(text = it)
            }
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onPasswordVisibilityChanged(!isPasswordVisible)
                }
            ) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = if (isPasswordVisible) stringResource(R.string.password_state_on)
                    else stringResource(R.string.password_state_off)
                )
            }
        },
        supportingText = {
            supportingText?.let {
                Text(text = it)
            }
        },
    )
}