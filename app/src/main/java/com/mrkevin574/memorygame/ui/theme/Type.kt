package com.mrkevin574.memorygame.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrkevin574.memorygame.R

val cinzelFontFamily = FontFamily(
    Font(R.raw.cinzel_black, FontWeight.Black),
    Font(R.raw.cinzel_bold, FontWeight.Bold),
    Font(R.raw.cinzel_extrabold, FontWeight.ExtraBold),
    Font(R.raw.cinzel_medium, FontWeight.Medium),
    Font(R.raw.cinzel_regular, FontWeight.Normal),
    Font(R.raw.cinzel_semibold, FontWeight.SemiBold)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = cinzelFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)