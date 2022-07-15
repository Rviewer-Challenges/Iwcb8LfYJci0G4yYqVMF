package com.mrkevin574.memorygame.presentation.screens.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import com.mrkevin574.memorygame.util.Difficult
import com.mrkevin574.memorygame.util.Screen

@Composable
fun StartScreen(navController: NavController? = null) {

    val difficult = remember { mutableStateOf(Difficult.Easy) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextStartScreen()
        DifficultText(difficult = difficult)
        Divider(
            modifier = Modifier.height(100.dp),
            color = Primary
        )
        ButtonStart { navController?.navigate(Screen.Game.passDifficult(
            difficult.value
        )) }
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
            .padding(
                start = 30.dp,
                end = 30.dp
            ),
        textAlign = TextAlign.Center,
        fontSize = 40.sp,
        fontFamily = cinzelFontFamily,
        lineHeight = TextUnit(50f, TextUnitType.Sp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DifficultText(difficult: MutableState<Difficult>) {
    Text(
        text = difficult.value.name,
        color = Color.White,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        fontFamily = cinzelFontFamily,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
            .clickable {
                when (difficult.value) {
                    Difficult.Easy -> difficult.value = Difficult.Medium
                    Difficult.Medium -> difficult.value = Difficult.Hard
                    Difficult.Hard -> difficult.value = Difficult.Easy
                }
            }
    )
}

@Composable
fun ButtonStart(onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .width(250.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Accent
        )
    ) {
        Text(
            text = stringResource(R.string.start),
            color = Color.Black,
            fontFamily = cinzelFontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}