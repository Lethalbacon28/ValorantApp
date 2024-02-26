package com.example.valorantapp

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class ContentTier(
    val displayName: String,
    val displayIcon: String,
    val uuid: String
    ): Parcelable
