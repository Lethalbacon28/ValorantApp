package com.example.valorantapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
    object RetrofitHelper {

        val baseUrl = "https://valorant-api.com/v1/weapons/skins"

        fun getInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
