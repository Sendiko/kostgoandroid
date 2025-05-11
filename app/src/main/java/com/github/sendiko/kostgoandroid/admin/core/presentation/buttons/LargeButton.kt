package com.github.sendiko.kostgoandroid.admin.core.presentation.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme
import com.github.sendiko.kostgoandroid.core.ui.theme.PrimaryOrange

@Composable
fun LargeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryOrange,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
private fun LargeButtonPrev() {
    KostgoandroidTheme {
        Surface {
            LargeButton(
                modifier = Modifier.padding(16.dp),
                onClick = {},
                text = "Register"
            )
        }
    }
}