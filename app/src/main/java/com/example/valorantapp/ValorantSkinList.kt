package com.example.valorantapp

import kotlinx.parcelize.Parcelize

@Parcelize
data class ValorantSkinList(
    var valorantList: List<WeaponSkinData>
)
