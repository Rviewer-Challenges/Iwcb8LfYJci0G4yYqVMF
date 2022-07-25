package com.mrkevin574.memorygame.presentation.screens.gamescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.memorygame.R
import com.mrkevin574.memorygame.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameOverDialog(
    viewModel: GameViewModel = hiltViewModel(),
    text : String,
    onExit: () -> Unit
) {
    if (viewModel.gameOver.value) {
        Dialog(
            onDismissRequest = {
                onExit()
                viewModel.gameOver.value = false
            }
        ) {
            Card(
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AlertDialogColor
                )
            ) {
                TextGameWin()
            }
        }
    }
}

@Composable
fun TextGameWin() {
    Text(
        text = stringResource(R.string.game_over),
        color = Primary,
        fontFamily = cinzelFontFamily,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        fontWeight = FontWeight.Bold
    )
}

