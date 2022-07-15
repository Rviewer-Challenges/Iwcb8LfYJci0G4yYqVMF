package com.mrkevin574.memorygame.presentation.screens.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.ui.theme.Accent
import com.mrkevin574.memorygame.ui.theme.Primary
import com.mrkevin574.memorygame.ui.theme.cinzelFontFamily

@Composable
fun StartScreen(navController: NavController? = null) {

        Row(
            modifier = Modifier.fillMaxSize()
                .background(Primary)
        ) {
            TextStartScreen()
        }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TextStartScreen() {
    Text(
        text = stringResource(R.string.title_start_screen),
        color = Accent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp,
            start = 30.dp,
            end = 30.dp),
        textAlign = TextAlign.Center,
        fontSize = 40.sp,
        fontFamily = cinzelFontFamily,
        lineHeight = TextUnit(50f, TextUnitType.Sp),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}