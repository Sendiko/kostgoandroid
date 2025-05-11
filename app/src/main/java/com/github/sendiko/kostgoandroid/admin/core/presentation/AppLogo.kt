package com.github.sendiko.kostgoandroid.admin.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.sendiko.kostgoandroid.R
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme
import com.github.sendiko.kostgoandroid.core.ui.theme.LalezarFont

@Composable
fun AppLogo(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.kost_go),
            contentDescription = stringResource(R.string.app_name)
        )
        Text(
            text = stringResource(R.string.app_name),
            fontFamily = LalezarFont,
            fontSize = 24.sp
        )
    }
}

@Preview
@Composable
private fun AppLogoPrev() {
    KostgoandroidTheme {
        Surface { AppLogo() }
    }
}