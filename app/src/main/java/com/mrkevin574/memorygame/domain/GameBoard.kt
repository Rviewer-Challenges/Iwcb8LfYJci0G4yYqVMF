package com.mrkevin574.memorygame.domain

import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.DimenGame
import com.mrkevin574.memorygame.domain.model.GameSpecs
import com.mrkevin574.memorygame.util.Difficult
import kotlin.random.Random

object GameBoard {

    fun getGameSpecs(difficult: Difficult): GameSpecs {
        val dimens = getDimenByDifficult(difficult)
        val board = getRandomCardsByDifficult(dimens)
        return GameSpecs(board = board, dimenGame = dimens)
    }

    private fun getRandomCardsByDifficult(dimens: DimenGame): List<Card> {
        val totalSizeOfCards = (dimens.horizontal * dimens.vertical) / 2

        val cards = getAllCards()
        val secondsCards = mutableListOf<Card>()

        val finalCardList = mutableListOf<Card>()
        val randomCards1 = mutableListOf<Card>()
        val randomCards2 = mutableListOf<Card>()


        for (i in 0 until totalSizeOfCards) {
            val card = cards.random(Random(System.nanoTime()))
            randomCards1.add(card)
            secondsCards.add(card)
            cards.remove(card)
        }
        for (i in 0 until totalSizeOfCards) {
            val card = secondsCards.random(Random(System.nanoTime()))
            randomCards2.add(card)
            secondsCards.remove(card)
        }
        finalCardList.addAll(randomCards1)
        finalCardList.addAll(randomCards2)

        return finalCardList
    }

    private fun getDimenByDifficult(difficult: Difficult): DimenGame {
        return when (difficult) {
            Difficult.Easy -> DimenGame(horizontal = 4, vertical = 4, width = 100, height = 200)
            Difficult.Medium -> DimenGame(horizontal = 4, vertical = 6, width = 100, height = 135)
            Difficult.Hard -> DimenGame(horizontal = 5, vertical = 6, width = 80, height = 135)
        }
    }

    private fun getAllCards(): MutableList<Card> {
        return mutableListOf(
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