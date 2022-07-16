package com.mrkevin574.memorygame.domain.model

data class GameSpecs(val board : List<Card> = emptyList(), val dimenGame: DimenGame = DimenGame(0,0,0,0))
