package com.example.valorantapp

import android.widget.ImageView
import java.util.UUID
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ContentTier(
    val dislpayName: String,
    val displayIcon: String,
    val uuid: UUID
    ): Parcelable
