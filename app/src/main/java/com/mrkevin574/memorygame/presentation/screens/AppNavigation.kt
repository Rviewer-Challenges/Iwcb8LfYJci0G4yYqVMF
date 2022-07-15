package com.mrkevin574.memorygame.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrkevin574.memorygame.presentation.screens.gamescreen.GameScreen
import com.mrkevin574.memorygame.presentation.screens.startscreen.StartScreen
import com.mrkevin574.memorygame.util.Difficult
import com.mrkevin574.memorygame.util.Screen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.Start.route ){
        composable(Screen.Start.route){
            StartScreen(navController)
        }
        composable(Screen.Game.route){
            val difficult = when(it.arguments?.getString("difficult"))
            {
                Difficult.Easy.name -> Difficult.Easy
                Difficult.Medium.name -> Difficult.Medium
                Difficult.Hard.name -> Difficult.Hard
                else -> Difficult.Medium
            }
            GameScreen(navController = navController, difficult)
        }
    }
}