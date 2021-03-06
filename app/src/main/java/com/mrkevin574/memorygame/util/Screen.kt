package com.mrkevin574.memorygame.util

sealed class Screen(val route : String)
{
    object Start : Screen("start")
    object Game : Screen("game/{difficult}") {
        fun passDifficult(difficult : Difficult) = "game/${difficult.name}"
    }
}
