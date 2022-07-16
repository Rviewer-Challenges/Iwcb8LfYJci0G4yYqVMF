package com.mrkevin574.memorygame.presentation.screens.gamescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mrkevin574.memorygame.domain.GameBoard
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.GameSpecs
import com.mrkevin574.memorygame.util.Click
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

    fun onClickCard(card : Card) {
        val indexOfCard = gameState.value.board.indexOf(card)
        val board = gameState.value.board
        val passDimens = gameState.value.dimenGame
        
        board[indexOfCard].flipped = true

        val newTypeClick = when (gameState.value.typeClick) {
            Click.First -> {
                Click.Second
            }
            else -> Click.Second
        }

        gameState.value = GameSpecs(
            board = board,
            typeClick = newTypeClick,
            dimenGame = passDimens
        )
    }
}