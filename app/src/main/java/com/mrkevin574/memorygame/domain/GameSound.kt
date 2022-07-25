package com.mrkevin574.memorygame.domain

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GameSound @Inject constructor(
    @ApplicationContext private val context : Context
){
    fun play(resourceId : Int){
        val mediaPlayer : MediaPlayer? = MediaPlayer.create(context, resourceId)
        mediaPlayer?.start()
    }
}