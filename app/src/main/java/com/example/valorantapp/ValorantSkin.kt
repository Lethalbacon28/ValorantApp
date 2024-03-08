package com.example.valorantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValorantSkin(
    val displayName: String,
    val displayIcon: String? = "",
    val contentTierUuid: String,
    val streamedVideo: String? = "",
    val chromas: List<Chromas>,
    val levels: List<Levels>,
    val fullRender: String? = ""
): Parcelable