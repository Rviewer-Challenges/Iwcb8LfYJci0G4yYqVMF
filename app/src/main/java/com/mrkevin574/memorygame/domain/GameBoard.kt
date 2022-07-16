package com.mrkevin574.memorygame.domain

import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.DimenGame
import com.mrkevin574.memorygame.domain.model.GameSpecs
import com.mrkevin574.memorygame.util.Difficult
import kotlin.random.Random

object GameBoard {

    private fun getGameSpecs(difficult: Difficult): GameSpecs {
        val dimens = getDimenByDifficult(difficult)
        val board = getRandomCardsByDifficult(dimens)
        return GameSpecs(board = board, dimenGame = dimens)
    }

    private fun getRandomCardsByDifficult(dimens: DimenGame): List<Card> {
        val totalSizeOfCards = (dimens.horizontal * dimens.vertical) / 2
        val cards = getAllCards()
        val finalCardList = mutableListOf<Card>()
        val randomCards1 = mutableListOf<Card>()
        val randomCards2 = mutableListOf<Card>()

        for (i in 0 until totalSizeOfCards) {
            randomCards1.add(cards.random(Random(System.nanoTime())))
        }
        for (i in 0 until totalSizeOfCards) {
            randomCards2.add(cards.random(Random(System.nanoTime())))
        }
        finalCardList.addAll(randomCards1)
        finalCardList.addAll(randomCards2)

        return finalCardList
    }

    private fun getDimenByDifficult(difficult: Difficult): DimenGame {
        return when (difficult) {
            Difficult.Easy -> DimenGame(horizontal = 4, vertical = 4, width = 70, height = 160)
            Difficult.Medium -> DimenGame(horizontal = 4, vertical = 6, width = 70, height = 160)
            Difficult.Hard -> DimenGame(horizontal = 5, vertical = 6, width = 70, height = 160)
        }
    }

    private fun getAllCards(): List<Card> {
        return listOf(
            Card(resId = R.drawable.card_01, uniqueId = 1, flipped = false),
            Card(resId = R.drawable.card_02, uniqueId = 2, flipped = false),
            Card(resId = R.drawable.card_03, uniqueId = 3, flipped = false),
            Card(resId = R.drawable.card_04, uniqueId = 4, flipped = false),
            Card(resId = R.drawable.card_05, uniqueId = 5, flipped = false),
            Card(resId = R.drawable.card_06, uniqueId = 6, flipped = false),
            Card(resId = R.drawable.card_07, uniqueId = 7, flipped = false),
            Card(resId = R.drawable.card_08, uniqueId = 8, flipped = false),
            Card(resId = R.drawable.card_09, uniqueId = 9, flipped = false),
            Card(resId = R.drawable.card_10, uniqueId = 10, flipped = false),
            Card(resId = R.drawable.card_11, uniqueId = 11, flipped = false),
            Card(resId = R.drawable.card_12, uniqueId = 12, flipped = false),
            Card(resId = R.drawable.card_13, uniqueId = 13, flipped = false),
            Card(resId = R.drawable.card_14, uniqueId = 14, flipped = false),
            Card(resId = R.drawable.card_15, uniqueId = 15, flipped = false)
        )
    }

}