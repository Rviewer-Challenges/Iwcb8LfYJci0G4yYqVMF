package com.mrkevin574.memorygame.presentation.screens.gamescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mrkevin574.memorygame.domain.GameBoard
import com.mrkevin574.memorygame.domain.model.GameSpecs
import com.mrkevin574.memorygame.util.Difficult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel(){

    val gameState = mutableStateOf(GameSpecs())

    fun startGame(difficult: Difficult)
    {
        gameState.value = GameBoard.getGameSpecs(difficult)
    }
}