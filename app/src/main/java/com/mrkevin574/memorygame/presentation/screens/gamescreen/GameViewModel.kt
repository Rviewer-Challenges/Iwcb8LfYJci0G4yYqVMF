package com.mrkevin574.memorygame.presentation.screens.gamescreen

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.domain.GameBoard
import com.mrkevin574.memorygame.domain.GameSound
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.GameSpecs
import com.mrkevin574.memorygame.util.Click
import com.mrkevin574.memorygame.util.Difficult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameSound : GameSound
) : ViewModel(){

    val gameState = mutableStateOf(GameSpecs())

    val movements = mutableStateOf(0)

    val couplesLeft = mutableStateOf(0)

    val timeLeft = mutableStateOf("1:00")

    val gameOver = mutableStateOf(false)

    var isWinner = false

    var isTimeRunning = false

    private lateinit var firstPassCard : Card
    private var secondPassCard : Card? = null

    private val timer = object  : CountDownTimer(60000,1000){
        override fun onTick(millisUntilFinished: Long) {
            isTimeRunning = true
            timeLeft.value = "${(millisUntilFinished / 1000 / 60).toInt()}:${(millisUntilFinished / 1000 % 60)}"
        }

        override fun onFinish() {
            isWinner = false
            isTimeRunning = false
            gameOver.value = true
            gameSound.play(R.raw.game_over)
        }

    }

    fun startGame(difficult: Difficult)
    {
        gameState.value = GameBoard.getGameSpecs(difficult)
        couplesLeft.value  = gameState.value.board.size / 2
    }

    fun onClickCard(card : Card) {
        val indexOfCard = gameState.value.board.indexOf(card)
        val board = gameState.value.board
        val passDimens = gameState.value.dimenGame

        if(secondPassCard != null)
        {
            val indexOfFirstPassCard = gameState.value.board.indexOf(firstPassCard)
            val indexOfSecondPassCard = gameState.value.board.indexOf(secondPassCard)

            board[indexOfFirstPassCard].flipped = false
            board[indexOfSecondPassCard].flipped = false

            secondPassCard = null
        }
        
        board[indexOfCard].flipped = true

        val newTypeClick = when (gameState.value.typeClick) {
            Click.First -> {
                if(!isTimeRunning) timer.start()
                firstPassCard = card
                Click.Second
            }
            else -> {
                movements.value++
                if(firstPassCard.uniqueId == card.uniqueId)
                {
                    gameSound.play(R.raw.correct_click)
                    couplesLeft.value--
                    secondPassCard = null
                    if(couplesLeft.value == 0)
                    {
                        isWinner = true
                        gameSound.play(R.raw.win_game)
                        gameOver.value = true
                        timer.cancel()
                    }
                }else{
                    secondPassCard = card
                    gameSound.play(R.raw.click_error)
                }
                Click.First
            }
        }

        gameState.value = GameSpecs(
            board = board,
            typeClick = newTypeClick,
            dimenGame = passDimens
        )
    }
}