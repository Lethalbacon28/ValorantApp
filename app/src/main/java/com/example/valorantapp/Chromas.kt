package com.example.valorantapp

import android.widget.ImageView
import android.widget.VideoView
import java.util.UUID
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
@Parcelize
data class Chromas(
    val uuid: UUID,
    val displayIcon: String,
    val streamedVideo: String
    ): Parcelable
