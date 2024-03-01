package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ValorantChroma : AppCompatActivity() {

    companion object{
        val EXTRA_VALO = "valorantSkin"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valorant_chroma)
    }
}