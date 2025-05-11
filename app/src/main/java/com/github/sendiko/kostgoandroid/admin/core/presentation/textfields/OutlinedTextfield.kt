package com.github.sendiko.kostgoandroid.admin.core.presentation.textfields

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme
import com.github.sendiko.kostgoandroid.core.ui.theme.PrimaryOrange

/**
 *
 * Kost Go's custom OutlinedTexfields
 *
 * */
@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    isError: Boolean = false,
    supportingText: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
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
        supportingText = {
            supportingText?.let {
                Text(text = it)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Preview
@Composable
private fun OutlinedTextFieldPrev() {
    KostgoandroidTheme {
        Surface {
            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                value = "",
                onValueChange = {},
                hint = "Hint",
                isError = true,
                supportingText = "Supporting Text"
            )
        }
    }
}