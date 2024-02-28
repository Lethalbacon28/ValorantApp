package com.example.valorantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    var data: List<ValorantSkin?>? = null
): Parcelable
