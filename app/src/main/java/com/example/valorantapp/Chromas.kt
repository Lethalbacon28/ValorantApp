package com.example.valorantapp

import android.os.Parcelable
import android.widget.ImageView
import android.widget.VideoView
import kotlinx.parcelize.Parcelize
import java.util.UUID
@Parcelize
data class Chromas(
    val uuid: String,
    val displayIcon: String,
    val streamedVideo: String
    ): Parcelable