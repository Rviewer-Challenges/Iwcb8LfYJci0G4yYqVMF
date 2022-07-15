package com.mrkevin574.memorygame.presentation.screens.gamescreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mrkevin574.memorygame.util.Difficult

@Composable
fun GameScreen(navController: NavController, difficult: Difficult) {
    Text(difficult.name)
}