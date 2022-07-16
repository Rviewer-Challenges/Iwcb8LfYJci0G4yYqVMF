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
        val board = getRandomCardsByDifficult(difficult)
        return GameSpecs(board = board, dimenGame = dimens)
    }

    private fun getRandomCardsByDifficult(difficult: Difficult): List<Card> {

        val cards: MutableList<Card>
        val secondsCards: MutableList<Card>

        when (difficult) {
            Difficult.Easy -> {
                cards = getEasyCards()
                secondsCards = getEasyCards()
            }
            Difficult.Medium -> {
                cards = getMediumCards()
                secondsCards = getMediumCards()
            }
            Difficult.Hard -> {
                cards = getHardCards()
                secondsCards = getHardCards()
            }
        }

        val randomCards = getRandomCardsOfList(cards)
        randomCards.addAll(getRandomCardsOfList(secondsCards))

        return randomCards
    }

    private fun getRandomCardsOfList(cards: MutableList<Card>): MutableList<Card> {
        val randomCards = mutableListOf<Card>()
        for (i in cards.indices) {
            val card = cards.random(Random(System.nanoTime()))
            randomCards.add(card)
            cards.remove(card)
        }
        return randomCards
    }

    private fun getDimenByDifficult(difficult: Difficult): DimenGame {
        return when (difficult) {
            Difficult.Easy -> DimenGame(horizontal = 4, vertical = 4, width = 100, height = 200)
            Difficult.Medium -> DimenGame(horizontal = 4, vertical = 6, width = 100, height = 135)
            Difficult.Hard -> DimenGame(horizontal = 5, vertical = 6, width = 80, height = 135)
        }
    }

    private fun getEasyCards(): MutableList<Card> {
        return mutableListOf(
            Card.ID01(),
            Card.ID02(),
            Card.ID03(),
            Card.ID04(),
            Card.ID05(),
            Card.ID06(),
            Card.ID07(),
            Card.ID08(),
        )
    }

    private fun getMediumCards(): MutableList<Card> {
        return mutableListOf(
            Card.ID01(),
            Card.ID02(),
            Card.ID03(),
            Card.ID04(),
            Card.ID05(),
            Card.ID06(),
            Card.ID07(),
            Card.ID08(),
            Card.ID09(),
            Card.ID10(),
            Card.ID11(),
            Card.ID12(),
        )
    }

    private fun getHardCards(): MutableList<Card> {
        return mutableListOf(
            Card.ID01(),
            Card.ID02(),
            Card.ID03(),
            Card.ID04(),
            Card.ID05(),
            Card.ID06(),
            Card.ID07(),
            Card.ID08(),
            Card.ID09(),
            Card.ID10(),
            Card.ID11(),
            Card.ID12(),
            Card.ID13(),
            Card.ID14(),
            Card.ID15(),
        )
    }

}