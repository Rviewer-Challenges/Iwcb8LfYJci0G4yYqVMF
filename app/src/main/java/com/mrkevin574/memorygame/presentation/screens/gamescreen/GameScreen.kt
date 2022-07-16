package com.mrkevin574.memorygame.presentation.screens.gamescreen

import android.view.ContentInfo
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.domain.model.Card
import com.mrkevin574.memorygame.domain.model.DimenGame
import com.mrkevin574.memorygame.ui.theme.Accent
import com.mrkevin574.memorygame.ui.theme.Primary
import com.mrkevin574.memorygame.ui.theme.cinzelFontFamily
import com.mrkevin574.memorygame.util.Difficult
import com.mrkevin574.memorygame.util.Screen

@Composable
fun GameScreen(
    navController: NavController,
    difficult: Difficult,
    viewModel: GameViewModel = hiltViewModel()
) {
    if (viewModel.gameState.value.board.isEmpty())
        viewModel.startGame(difficult)

    val gameSpecs = viewModel.gameState.value
    val cards = gameSpecs.board
    val dimens = gameSpecs.dimenGame

    val movements = viewModel.movements.value
    val couplesLeft = viewModel.couplesLeft.value
    val timeLeft = viewModel.timeLeft.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    )
    {
        ContentInfo(
            movements = movements,
            couplesLeft = couplesLeft,
            timeLeft = timeLeft
        )
        ContentBoard(dimens = dimens, cards = cards) {
            viewModel.onClickCard(it)
        }
    }

    GameOverDialog {
        navController.navigate(Screen.Start.route)
    }

}

@Composable
fun ContentInfo(movements : Int, couplesLeft : Int, timeLeft : String) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 30.dp)
    ) {
        TextInfo(label = "Mov", text = movements.toString())
        TextInfo(text = timeLeft)
        TextInfo(label = "Left", text = couplesLeft.toString())
    }
}

@Composable
fun TextInfo(label : String = "", text : String) {
    val divider = if(label.isEmpty()) "" else ": "
    Text(
        text = "$label$divider$text",
        color = Accent,
        fontFamily = cinzelFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
fun ContentBoard(dimens: DimenGame, cards: List<Card>, onClickCard: (Card) -> Unit) {

    var actualIndex = 0

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until dimens.horizontal) {
            Column {
                for (j in 0 until dimens.vertical) {
                    val actualCard = cards[actualIndex]
                    Card(
                        card = actualCard,
                        width = dimens.width,
                        height = dimens.height
                    ) {
                        onClickCard(actualCard)
                    }
                    actualIndex++
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Card(card: Card, width: Int, height: Int, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        border = BorderStroke(0.dp, Color.White)
    )
    {
        if (card.flipped) {
            Image(
                painter = painterResource(
                    id = card.resId
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(width.dp)
                    .height(height.dp)
                    .padding(4.dp),
                contentScale = ContentScale.FillBounds
            )
        } else {
            Box(
                modifier = Modifier
                    .width(width.dp)
                    .height(height.dp)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "?",
                    fontFamily = cinzelFontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Accent
                )
            }

        }

    }

}