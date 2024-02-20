package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.databinding.ActivityValorantBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Valorant : AppCompatActivity() {

    private lateinit var binding: ActivityValorantBinding
    private lateinit var valSkins: WeaponSkinData
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantBinding.inflate(layoutInflater)
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
    fun refreshList() {
        val adapter = ValorantAdapter(valSkins)
        binding..layoutManager = LinearLayoutManager(this)
        binding.EarthquakeListEarthquake.adapter = adapter
    }
}