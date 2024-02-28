package com.example.valorantapp

import retrofit2.Call
import retrofit2.http.GET

interface ValorantService {
    @GET("weapons/skins")
    fun getValoSkin(): Call<Data>
}