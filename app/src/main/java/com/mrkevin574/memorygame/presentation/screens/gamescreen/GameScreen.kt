package com.mrkevin574.memorygame.presentation.screens.gamescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.DimenGame
import com.mrkevin574.memorygame.ui.theme.Primary
import com.mrkevin574.memorygame.util.Difficult

@Composable
fun GameScreen(
    navController: NavController,
    difficult: Difficult,
    viewModel: GameViewModel = hiltViewModel()
) {
    viewModel.startGame(difficult)
    val gameSpecs = viewModel.gameState.value
    val dimens = gameSpecs.dimenGame
    var actualIndex = 0

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until dimens.horizontal) {
            Column {
                for (j in 0 until dimens.vertical) {
                    val actualCard = gameSpecs.board[actualIndex]
                    Card(
                        card = actualCard,
                        width = dimens.width,
                        height = dimens.height
                    )
                }
                actualIndex++
            }

        }
    }

}

@Composable
fun Card(card: Card, width: Int, height: Int) {
    Image(
        painter = painterResource(
            id = if (card.flipped) card.resId else R.drawable.card_back_02
        ),
        contentDescription = null,
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .padding(4.dp),
        contentScale = ContentScale.FillBounds
    )
}