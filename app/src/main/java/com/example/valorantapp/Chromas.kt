package com.example.valorantapp

import android.widget.ImageView
import android.widget.VideoView
import java.util.UUID

data class Chromas(
    val uuid: UUID,
    val displayIcon: ImageView,
    val streamedVideo: VideoView
    )
