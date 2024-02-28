package com.example.valorantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentTierUuid(
    val displayName: String,
    val displayIcon: String,
    val uuid: String
): Parcelable