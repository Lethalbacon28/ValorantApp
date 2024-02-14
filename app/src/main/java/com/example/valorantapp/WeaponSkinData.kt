package com.example.valorantapp

import android.os.Parcelable
import android.widget.ImageView
import android.widget.VideoView
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class WeaponSkinData(
    val displayName: String,
    val displayIcon: String,
    val contentTier: ContentTier,
    val streamedVideo: String,
    val chromas: Chromas
): Parcelable

