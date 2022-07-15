package com.mrkevin574.memorygame.presentation.screens.startscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController? = null) {
    TextStartScreen()
}

@Composable
fun TextStartScreen() {
    Text(
        text = "Memory Game of MTG Arena"
    )
}

@Preview
@Composable
fun PreviewStartScreen() {
    StartScreen()
}