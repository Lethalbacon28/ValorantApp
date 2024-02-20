package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.valorantapp.databinding.ActivityValorantListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ValorantListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValorantListBinding
    private lateinit var valSkins: WeaponSkinData
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = resources.openRawResource(R.raw.skins)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "OnCreate: jsonString $jsonString")
        val gson = Gson()
        val type = object: TypeToken<WeaponSkinData>() {
        }.type
        valSkins = gson.fromJson(jsonString, type)

        Log.d(TAG,"LoadEarthquakes $valSkins")
    }
}