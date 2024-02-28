package com.example.valorantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValorantSkin(
    val displayName: String,
    val displayIcon: String,
    val contentTierUUid: String,
    val streamedVideo: String,
    val chromas: Chromas
): Parcelable
