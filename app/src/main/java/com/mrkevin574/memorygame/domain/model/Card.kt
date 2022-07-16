package com.mrkevin574.memorygame.domain.model

import com.mrkevin574.memorygame.R

sealed class Card(val resId : Int, val uniqueId : Int,var flipped : Boolean = false)
{
    class Beerus : Card(resId = R.drawable.beerus, uniqueId = 1)
    class Broly : Card(resId = R.drawable.broly, uniqueId = 2)
    class Cell : Card(resId = R.drawable.cell, uniqueId = 3)
    class Chaoz : Card(resId = R.drawable.chaoz, uniqueId = 4)
    class Freeza :Card(resId = R.drawable.freeza, uniqueId = 5)
    class Gohan : Card(resId = R.drawable.gohan, uniqueId = 6)
    class Goku : Card(resId = R.drawable.goku, uniqueId = 7)
    class Gotenks : Card(resId = R.drawable.gotenks, uniqueId = 8)
    class Jiren : Card(resId = R.drawable.jiren, uniqueId = 9)
    class KaioDelNorte : Card(resId = R.drawable.kaio_del_norte, uniqueId = 10)
    class Krilin :  Card(resId = R.drawable.krilin, uniqueId = 11)
    class MajinBoo :  Card(resId = R.drawable.majin_boo, uniqueId = 12)
    class Numero18 :  Card(resId = R.drawable.numero_18, uniqueId = 13)
    class Piccolo : Card(resId = R.drawable.piccolo, uniqueId = 14)
    class Vegeta : Card(resId = R.drawable.vegeta, uniqueId = 15)
}
