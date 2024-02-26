package com.example.valorantapp

import android.widget.ImageView
import android.widget.VideoView

data class WeaponSkinData(
    val displayName: String,
    val displayIcon: String,
    val contentTier: ContentTier,
    val streamedVideo: String,
    val chromas: Chromas
)
