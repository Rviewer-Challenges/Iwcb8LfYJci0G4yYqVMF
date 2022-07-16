package com.mrkevin574.memorygame.domain.model

import com.mrkevin574.memorygame.util.Click

data class GameSpecs(
    val board : List<Card> = emptyList(),
    val dimenGame: DimenGame = DimenGame(0,0,0,0),
    val typeClick: Click = Click.First)
