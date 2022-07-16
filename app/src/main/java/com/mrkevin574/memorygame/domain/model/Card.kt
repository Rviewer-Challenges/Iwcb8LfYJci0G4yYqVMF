package com.mrkevin574.memorygame.domain.model

import com.mrkevin574.memorygame.R

sealed class Card(val resId : Int, val uniqueId : Int,var flipped : Boolean = false)
{
    class ID01 : Card(resId = R.drawable.card_01, uniqueId = 1)
    class ID02 : Card(resId = R.drawable.card_02, uniqueId = 2)
    class ID03 : Card(resId = R.drawable.card_03, uniqueId = 3)
    class ID04 : Card(resId = R.drawable.card_04, uniqueId = 4)
    class ID05 :Card(resId = R.drawable.card_05, uniqueId = 5)
    class ID06 : Card(resId = R.drawable.card_06, uniqueId = 6)
    class ID07 : Card(resId = R.drawable.card_07, uniqueId = 7)
    class ID08 : Card(resId = R.drawable.card_08, uniqueId = 8)
    class ID09 : Card(resId = R.drawable.card_09, uniqueId = 9)
    class ID10 : Card(resId = R.drawable.card_10, uniqueId = 10)
    class ID11 :  Card(resId = R.drawable.card_11, uniqueId = 11)
    class ID12 :  Card(resId = R.drawable.card_12, uniqueId = 12)
    class ID13 :  Card(resId = R.drawable.card_13, uniqueId = 13)
    class ID14 : Card(resId = R.drawable.card_14, uniqueId = 14)
    class ID15 : Card(resId = R.drawable.card_15, uniqueId = 15)
}
