package com.example.valorantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValorantSkinList(
    var valorantList: List<WeaponSkinData>
): Parcelable
